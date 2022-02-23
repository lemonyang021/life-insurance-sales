package com.flywolf.li.framework.configcenter.event;

import com.flywolf.li.framework.configcenter.config.EChangeType;

public class ConfigChangeEvent {
  private EChangeType type = null;
  private String key = null;
  private String value = null;

  public EChangeType getType() {
    return type;
  }

  public void setType(EChangeType type) {
    this.type = type;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
