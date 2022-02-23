package com.flywolf.li.framework.configcenter.client;

import java.util.HashMap;
import java.util.Map;

public class Config {
  private String profile = null;
  private String application = null;
  private String label = "snapshot";
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

  public Config() {

  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

}
