package com.flywolf.li.framework.context;

import java.util.Map;

public class ExtensionContext {
  private ExtensionContext() {
    throw new IllegalStateException("Utility class");
  }

  private static ThreadLocal<Map<String, String>> forwardHeaders = new ThreadLocal<>();

  public static void setForwardHeaders(Map<String, String> dirtyWork) {
    forwardHeaders.set(dirtyWork);
  }

  public static Map<String, String> getForwardHeaders() {
    return forwardHeaders.get();
  }

  public static void reset() {
    forwardHeaders.remove();
  }
}
