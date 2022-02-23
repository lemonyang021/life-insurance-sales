package com.flywolf.li.framework.validator;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public abstract class AbstractValidator implements Validator {
  public static final String NODE_ISEMPTY = "node.isEmpty";
  private static final String NODE_ILLEGAL = "node.illegal";
  private static final String EMPTY_MSG = " is empty.";

  protected void rejectForIllegalEmail(Errors errors, String field) {
    Object fieldValue = errors.getFieldValue(field);
    if (fieldValue != null && !GenericValidator.isEmail(fieldValue.toString())) {
      errors.rejectValue(field, NODE_ILLEGAL, new Object[] {fixedField(errors, field)},
          field + " is illegal.");
    }
  }

  protected String fixedField(Errors errors, String field) {
    if (StringUtils.hasLength(field)) {
      return errors.getNestedPath() + PropertyAccessorUtils.canonicalPropertyName(field);
    } else {
      String path = errors.getNestedPath();
      return (path.endsWith(Errors.NESTED_PATH_SEPARATOR)
          ? path.substring(0, path.length() - Errors.NESTED_PATH_SEPARATOR.length())
          : path);
    }
  }

  protected void rejectForEmpty(Errors errors, String field) {
    errors.rejectValue(field, NODE_ISEMPTY, new Object[] {fixedField(errors, field)},
        field + EMPTY_MSG);
  }

  protected void rejectIfEmpty(Errors errors, String filed) {
    ValidationUtils.rejectIfEmpty(errors, filed, NODE_ISEMPTY,
        new Object[] {fixedField(errors, filed)}, filed + EMPTY_MSG);
  }

  protected void rejectIfEmptyOrWhitespace(Errors errors, String filed) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, filed, NODE_ISEMPTY,
        new Object[] {fixedField(errors, filed)}, filed + EMPTY_MSG);
  }
}
