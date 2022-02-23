package com.flywolf.li.pub;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

public class LiBeanUtils {

  public static void copyProperties(Object source, Object target, boolean nullUpdate,
      String... ignoreProperties) throws BeansException {
    copyProperties(source, target, null, nullUpdate, ignoreProperties);
  }

  private static void copyProperties(Object source, Object target, Class<?> editable,
      boolean nullUpdate, String... ignoreProperties) throws BeansException {

    Assert.notNull(source, "Source must not be null");
    Assert.notNull(target, "Target must not be null");

    Class<?> actualEditable = target.getClass();
    if (editable != null) {
      if (!editable.isInstance(target)) {
        throw new IllegalArgumentException("Target class [" + target.getClass().getName()
            + "] not assignable to Editable class [" + editable.getName() + "]");
      }
      actualEditable = editable;
    }
    PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
    List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

    for (PropertyDescriptor targetPd : targetPds) {
      Method writeMethod = targetPd.getWriteMethod();
      if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
        PropertyDescriptor sourcePd =
            BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
        if (sourcePd != null) {
          Method readMethod = sourcePd.getReadMethod();
          if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0],
              readMethod.getReturnType())) {
            try {
              ReflectionUtils.makeAccessible(readMethod);
              Object value = readMethod.invoke(source);
              ReflectionUtils.makeAccessible(writeMethod);
              if (value != null || nullUpdate) {
                writeMethod.invoke(target, value);
              }
            } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException  ex) {
              throw new FatalBeanException(
                  "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
            }
          }
        }
      }
    }
  }
}
