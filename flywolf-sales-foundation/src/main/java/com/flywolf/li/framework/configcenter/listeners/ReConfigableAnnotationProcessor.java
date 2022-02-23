package com.flywolf.li.framework.configcenter.listeners;

import java.lang.reflect.Field;

import com.flywolf.li.framework.configcenter.config.ReConfigable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;


/**
 * 其目的是记录带有reConfigable注解的缓存,因为其存在前缀,所以只要将前缀记录即可
 * 
 * @author shawn.yang
 */
public class ReConfigableAnnotationProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    ConfigurationProperties configurationProperties =
        AnnotatedElementUtils.findMergedAnnotation(bean.getClass(), ConfigurationProperties.class);

    if (configurationProperties == null) {
      processValueAnnotation(bean, beanName);
    } else if (AnnotatedElementUtils.isAnnotated(bean.getClass(), ReConfigable.class)) {
      String prefix = configurationProperties.prefix();
      ReConfigableMetadata meta = new ReConfigableMetadata();
      meta.setBeanName(beanName);
      meta.setSource(bean);
      meta.setConfigPattern(prefix);
      ReCofigableMetadataHolder.getInstace().register(meta);
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

  private void processValueAnnotation(Object bean, String beanName) {
    ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {

      @Override
      public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        Value value = AnnotatedElementUtils.findMergedAnnotation(field, Value.class);
        String pattern = clean(value.value());
        if (pattern != null) {
          ReConfigableMetadata meta = new ReConfigableMetadata();
          // 不要设置此bean,可能bean会被覆盖
          meta.setBeanName(beanName);
          meta.setConfigPattern(pattern);
          meta.setValueAnnotation(true);
          meta.setSource(field);
          ReCofigableMetadataHolder.getInstace().register(meta);
        }
      }
    }, new FieldFilter() {
      @Override
      public boolean matches(Field field) {
        return AnnotatedElementUtils.isAnnotated(field, Value.class)
            && AnnotatedElementUtils.isAnnotated(field, ReConfigable.class) && AnnotatedElementUtils
                .findMergedAnnotation(field, ReConfigable.class).excluded() == false;
      }

    });

  }

  protected String clean(String value) {
    int start = value.indexOf("{");
    int end = value.indexOf("}");
    if (start > 0 && end > 0 || start < end) {
      return value.substring(start + 1, end);
    }
    return null;
  }



}
