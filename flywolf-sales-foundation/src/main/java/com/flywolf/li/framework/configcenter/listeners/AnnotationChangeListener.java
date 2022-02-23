package com.flywolf.li.framework.configcenter.listeners;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import com.flywolf.li.framework.configcenter.config.EChangeType;
import com.flywolf.li.framework.configcenter.config.IConfigChangeListener;
import com.flywolf.li.framework.configcenter.config.ReConfigable;
import com.flywolf.li.framework.configcenter.event.ConfigChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ReflectionUtils;

/**
 * 修改基于注解的参数
 * 
 * @author shawn.yang
 *
 */
public class AnnotationChangeListener implements IConfigChangeListener, BeanFactoryAware {

  private static Logger logger = LoggerFactory.getLogger(AnnotationChangeListener.class);
  @Autowired
  private ConfigurableEnvironment environment = null;

  private BeanFactory beanFactory = null;

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }

  @Override
  public void handle(Collection<ConfigChangeEvent> events) throws Exception {
    for (ConfigChangeEvent event : events) {
      ReConfigableMetadata metadata = ReCofigableMetadataHolder.getInstace().fetch(event.getKey());
      if (metadata == null) {
        continue;
      }
      if (metadata.isValueAnnotation()) {
        handleValueAnnotation(event, metadata);
      } else {
        handlePropertiesBean(event, metadata);
      }

    }
  }

  protected void handleValueAnnotation(ConfigChangeEvent event, ReConfigableMetadata metadata) {
    Field field = (Field) metadata.getSource();
    ReflectionUtils.makeAccessible(field);
    Object value = environment.getConversionService().convert(event.getValue(), field.getType());
    Object target = beanFactory.getBean(metadata.getBeanName());
    ReflectionUtils.setField(field, target, value);
  }

  protected void handlePropertiesBean(ConfigChangeEvent event, ReConfigableMetadata metadata)
      throws Exception {
    if (event.getType().equals(EChangeType.change) || event.getType().equals(EChangeType.add)) {
      String ognlPath = event.getKey().substring(metadata.getConfigPattern().length() + 1);
      if (ognlPath == null) {
        return;
      }
      int leftDotPos = ognlPath.indexOf('.');
      String fieldName = leftDotPos > 0 ? ognlPath.substring(0, leftDotPos) : ognlPath;
      ognlPath = leftDotPos > 0 ? ognlPath.substring(leftDotPos + 1) : null;
      Class<?> currentClazz = metadata.getSource().getClass();
      Field field = ReflectionUtils.findField(currentClazz, fieldName);
      Object target = metadata.getSource();
      while (field != null) {
        ReConfigable reConfigable = AnnotationUtils.findAnnotation(field, ReConfigable.class);
        if (reConfigable != null && reConfigable.excluded() == true) {
          break;
        }

        if (field.getType().isPrimitive() || field.getType().equals(String.class)
            || field.getType().isArray() || Collection.class.isAssignableFrom(field.getType())) {
          Object value =
              environment.getConversionService().convert(event.getValue(), field.getType());
          ReflectionUtils.makeAccessible(field);
          ReflectionUtils.setField(field, target, value);
          logger.info("success update the config named {} in bean {} ", event.getKey(),
              metadata.getBeanName());
          break;
        } else if (isMap(field)) {
          break;
        } else {
          if (ognlPath != null) {
            leftDotPos = ognlPath.indexOf('.');
            fieldName = leftDotPos > 0 ? ognlPath.substring(0, leftDotPos) : ognlPath;
            ognlPath = leftDotPos > 0 ? ognlPath.substring(leftDotPos + 1) : null;
            currentClazz = field.getType();
            ReflectionUtils.makeAccessible(field);
            target = field.get(target);
            field = ReflectionUtils.findField(currentClazz, fieldName);
          }
        }
      }
    }
  }

  private boolean isMap(Field field) {
    return Map.class.isAssignableFrom(field.getType());
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

}
