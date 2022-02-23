package com.flywolf.li.framework.configcenter;

import java.util.HashMap;
import java.util.Map;

class ConfigEvent {
  private String profile = null;
  private String application = null;
  private String label = null;

  /**
   * insert,remove,clear please see configengine documents
   */
  private String mode = null;
  private Map<String, Object> data = new HashMap<>();

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  public boolean isUpdate() {
    return "insert".equals(mode);
  }

  public boolean isRemove() {
    return "remove".equals(mode);
  }

  public boolean isClear() {
    return "clear".equals(mode);
  }
}
