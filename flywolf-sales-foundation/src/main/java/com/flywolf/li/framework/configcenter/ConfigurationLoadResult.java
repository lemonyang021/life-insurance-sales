package com.flywolf.li.framework.configcenter;

import org.springframework.core.env.MapPropertySource;

public class ConfigurationLoadResult {
  private MapPropertySource source = null;
  private String urls = null;
  private String application = null;

  private String profile = null;

  private String label = null;

  public MapPropertySource getSource() {
    return source;
  }

  public void setSource(MapPropertySource source) {
    this.source = source;
  }

  public String getUrls() {
    return urls;
  }

  public void setUrls(String urls) {
    this.urls = urls;
  }

  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
