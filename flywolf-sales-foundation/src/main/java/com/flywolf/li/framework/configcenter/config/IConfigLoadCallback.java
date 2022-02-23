package com.flywolf.li.framework.configcenter.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

public interface IConfigLoadCallback {
  /**
   * 在加载自定义配置之前调用
   * 
   * @param configurableEnvironment
   */
  public void beforeLoad(ConfigurableEnvironment configurableEnvironment);

  /**
   * 在propertySource 加入到 configurableEnvironment 之前调用
   * 
   * @param configurableEnvironment
   * @param propertySource
   */
  public void beforeAdd(ConfigurableEnvironment configurableEnvironment,
      MapPropertySource propertySource, String[] params);

  /**
   * 在propertySource 加入到 configurableEnvironment 之后调用
   * 
   * @param configurableEnvironment
   * @param propertySource
   */
  public void afterAdd(ConfigurableEnvironment configurableEnvironment,
      MapPropertySource propertySource, String[] params);
}
