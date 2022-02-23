package com.flywolf.li.framework.jpa;

import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

public abstract class BaseCriteria<T> {

  @ApiModelProperty(value = "Page No,Default Value is 0", example = "1", position = 70)
  protected int pageNo = 1;

  @ApiModelProperty(value = "Page Size,Default Value is 10", example = "10", position = 71)
  protected int pageSize = 10;

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public abstract Specification<T> toSpec();

  public Pageable toPageable() {
    return PageRequest.of(pageNo <= 1 ? 0 : pageNo - 1, pageSize);
  }

  public Pageable toPageable(Sort sort) {
    return  PageRequest.of(pageNo <= 1 ? 0 : pageNo - 1, pageSize, sort);
  }

  protected Specification<T> toSpecWithAnd() {
    return this.toSpecWithLogicType("and");
  }

  protected Specification<T> toSpecWithOr() {
    return this.toSpecWithLogicType("or");
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private Specification<T> toSpecWithLogicType(String logicType) {
    BaseCriteria outerThis = this;
    return (root, criteriaQuery, cb) -> {
      Class clazz = outerThis.getClass();
      List<Field> fields = getAllFieldsWithRoot(clazz);
      List<Predicate> predicates = new ArrayList<>(fields.size());
      for (Field field : fields) {
        QueryWord qw = field.getAnnotation(QueryWord.class);
        if (qw == null)
          continue;
        String column = qw.column();
        if (column.equals(""))
          column = field.getName();
        ReflectionUtils.makeAccessible(field);
        try {
          // nullable
          Object value = field.get(outerThis);
          // if null,and not annotation nullable,skip
          if (value == null && !qw.nullable())
            continue;
          // can be empty
          if (value != null && String.class.isAssignableFrom(value.getClass())) {
            String s = (String) value;
            // if "",and not annotation emptyable,skip
            if (s.equals("") && !qw.emptiable())
              continue;
          }

          Path path = root.get(column);
          switch (qw.func()) {
            case equal:
              predicates.add(cb.equal(path, value));
              break;
            case like:
              predicates.add(cb.like(path, "%" + value + "%"));
              break;
            case gt:
              predicates.add(cb.gt(path, (Number) value));
              break;
            case lt:
              predicates.add(cb.lt(path, (Number) value));
              break;
            case ge:
              predicates.add(cb.ge(path, (Number) value));
              break;
            case le:
              predicates.add(cb.le(path, (Number) value));
              break;
            case notEqual:
              predicates.add(cb.notEqual(path, value));
              break;
            case notLike:
              predicates.add(cb.notLike(path, "%" + value + "%"));
              break;
            case greaterThan:
              predicates.add(cb.greaterThan(path, (Comparable) value));
              break;
            case greaterThanOrEqualTo:
              predicates.add(cb.greaterThanOrEqualTo(path, (Comparable) value));
              break;
            case lessThan:
              predicates.add(cb.lessThan(path, (Comparable) value));
              break;
            case lessThanOrEqualTo:
              predicates.add(cb.lessThanOrEqualTo(path, (Comparable) value));
              break;
          }
        } catch (Exception e) {
          continue;
        }
      }
      Predicate p = null;
      if (logicType == null || logicType.equals("") || logicType.equals("and")) {
        p = cb.and(predicates.toArray(new Predicate[predicates.size()]));// and
      } else if (logicType.equals("or")) {
        p = cb.or(predicates.toArray(new Predicate[predicates.size()]));// or
      }
      return p;
    };
  }

  private List<Field> getAllFieldsWithRoot(Class<?> clazz) {
    List<Field> fieldList = new ArrayList<>();
    Field[] dFields = clazz.getDeclaredFields();
    if (null != dFields && dFields.length > 0)
      fieldList.addAll(Arrays.asList(dFields));
    Class<?> superClass = clazz.getSuperclass();
    if (superClass == Object.class)
      return Arrays.asList(dFields);
    List<Field> superFields = getAllFieldsWithRoot(superClass);
    if (null != superFields && !superFields.isEmpty()) {
      superFields.stream().filter(field -> !fieldList.contains(field))
          .forEach(field -> fieldList.add(field));
    }
    return fieldList;
  }
}
