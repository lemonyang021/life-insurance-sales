package com.flywolf.li.framework.configcenter.http;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


public class DefaultInetAddressFinder implements IInetAddressFinder {

  protected Logger logger = LoggerFactory.getLogger(getClass());
  private String ip = null;
  private String hostname = null;
  private String[] prioritySegments = new String[] {"172", "10", "192"};

  @Override
  public String find() {
    if (ip != null) {
      return ip;
    }
    ip = retryResolveIp();
    if (ip == null) {
      throw new RuntimeException("ip address can not found!");
    } else {
      logger.info("using ip {} for current application", ip);
      return ip;
    }

  }

  private String retryResolveIp() {
    int times = 3;
    String result = null;
    while (times >= 0 && result == null) {
      result = decide();
      if (result != null) {
        break;
      }

      times--;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        logger.error("InterruptedException", e);
        Thread.currentThread().interrupt();
      }
    }
    return result;
  }

  protected String decide() {
    String result = null;
    List<String> ipList = new ArrayList<>();
    try {
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      NetworkInterface networkInterface;
      Enumeration<InetAddress> inetAddresses;
      InetAddress inetAddress;
      String ip;
      while (networkInterfaces.hasMoreElements()) {
        networkInterface = networkInterfaces.nextElement();
        inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
          inetAddress = inetAddresses.nextElement();
          if (inetAddress != null && inetAddress instanceof Inet4Address) {
            ip = inetAddress.getHostAddress();
            ipList.add(ip);
          }
        }
      }

      result = ipv4filter(ipList);
    } catch (Throwable e) {
      logger.error("error when decide ip address", e.getMessage());
    }
    return result;
  }

  @Override
  public String hostname() {
    if (hostname != null) {
      return hostname;
    }
    try {
      InetAddress addr = InetAddress.getLocalHost();
      hostname = addr.getHostName();
    } catch (Exception ex) {

    }
    return hostname;
  }

  private String ipv4filter(List<String> ipList) throws Exception {
    if (ipList.size() < 1) {
      throw new Exception("the raw ip list size is 0");
    }

    final List<String> priority = Arrays.asList(prioritySegments);

    String result = null;
    for (String head : priority) {
      for (String ip : ipList) {
        if (ip.startsWith(head + ".")) {
          result = ip;
          break;
        }
      }

      if (result != null)
        break;
    }
    if (result == null) {
      logger.warn("the ip list {} is not matched the priority segments {},use the first one",
          StringUtils.collectionToCommaDelimitedString(ipList),
          StringUtils.collectionToCommaDelimitedString(priority));
      result = ipList.get(0);
    }

    return result;
  }
}
