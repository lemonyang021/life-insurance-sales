package com.flywolf.li.framework.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QueryWord {
  String column() default "";

  CriteriaMatchType func() default CriteriaMatchType.equal;

  boolean nullable() default false;

  boolean emptiable() default false;
}
