package com.flywolf.li.framework.configcenter.listeners;

public class ReConfigableMetadata {
  private String configPattern = null;
  private String beanName = null;
  private Object source = null;
  private boolean valueAnnotation = false;

  public String getConfigPattern() {
    return configPattern;
  }

  public void setConfigPattern(String configPattern) {
    this.configPattern = configPattern;
  }

  public String getBeanName() {
    return beanName;
  }

  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }

  public Object getSource() {
    return source;
  }

  public void setSource(Object source) {
    this.source = source;
  }

  public boolean isValueAnnotation() {
    return valueAnnotation;
  }

  public void setValueAnnotation(boolean valueAnnotation) {
    this.valueAnnotation = valueAnnotation;
  }
}
