package com.flywolf.li.framework.configcenter.http;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class DefaultPidFinder implements IPidFinder {
  private int pid = -1;

  @Override
  public int find() {
    if (pid != -1) {
      return pid;
    }

    pid = getPid();
    return pid;
  }

  protected int getPid() {
    RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    String name = runtime.getName(); // format: "pid@hostname"
    try {
      return Integer.parseInt(name.substring(0, name.indexOf('@')));
    } catch (Exception e) {
      return -1;
    }
  }
}
