package com.flywolf.li.framework.configcenter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConfigCenterProperties.class)
public class ConfigcenterAutoConfiguration {

//  @Bean
//  public ConfigChangeMonitor configChangeMonitor() {
//    return new ConfigChangeMonitor();
//  }

  // @Bean
  // public ConfigChangeListener configChangeListener(){
  // return new ConfigChangeListener();
  // }

//  @Bean
//  public AnnotationChangeListener annotationChangeListener() {
//    return new AnnotationChangeListener();
//  }
//
//  @Bean
//  public EnvironmentChangeListener environmentChangeListener() {
//    return new EnvironmentChangeListener();
//  }
//
//  @Bean
//  public ReConfigableAnnotationProcessor reConfigableAnnotationProcessor() {
//    return new ReConfigableAnnotationProcessor();
//  }
}
