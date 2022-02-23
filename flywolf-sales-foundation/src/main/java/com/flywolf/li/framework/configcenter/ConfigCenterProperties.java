package com.flywolf.li.framework.configcenter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ebao.platform.configcenter")
public class ConfigCenterProperties {
  private long initialDelay = 10l;
  private long delay = 10l;

  public long getInitialDelay() {
    return initialDelay;
  }

  public void setInitialDelay(long initialDelay) {
    this.initialDelay = initialDelay;
  }

  public long getDelay() {
    return delay;
  }

  public void setDelay(long delay) {
    this.delay = delay;
  }

}
