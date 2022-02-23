package com.flywolf.li.framework.configcenter.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReConfigable {
  /**
   * 如果这个属性为true,代表排除重载
   * 
   * @return
   */
  public boolean excluded() default false;
}
