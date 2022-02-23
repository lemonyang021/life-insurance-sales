package com.flywolf.li.framework.configcenter.http;

import org.springframework.util.StringUtils;


public class EnvAwareInetAddressFinder extends DefaultInetAddressFinder {
  private static final String ENV_preferIp = "preferIp";

  @Override
  protected String decide() {
    String value = fetchEvnConfig(ENV_preferIp);
    if (StringUtils.hasText(value)) {
      return value;
    } else {
      // InetAddress.getLocalHost() occasionally threw "UnknownHostException: System error"
      // i don't know why, just only retry it!!!
      String ip;
      do {
        ip = super.decide();
      } while (ip == null);

      return ip;
    }
  }

  /**
   * 需要重构,采用vmcaretaker
   *
   * @param envPreferip
   * @return
   */
  protected String fetchEvnConfig(String envPreferip) {
    return System.getenv(ENV_preferIp);
  }
}
