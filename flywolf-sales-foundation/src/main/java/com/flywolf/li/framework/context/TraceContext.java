package com.flywolf.li.framework.context;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.MDC;

public class TraceContext {

  private TraceContext() {
    throw new IllegalStateException("Utility class");
  }

  private static final String KEY_TRACE_ID = "liTraceId";
  private static final String KEY_ENTITY_ID = "entityId";
  private static final String KEY_TRANSACTION_ID = "transactionId";
  public static final String KEY_OPENTRACING_ID = "traceId";

  private static final String KEY_EXT_TRACE_ID = "extTraceId";
  private static final Set<String> extKeySet =
      Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

  private static final String KEY_EXT_TENANT = "tenant";

  public static void setTraceId(UUID traceId) {
    if (traceId == null) {
      return;
    }
    MDC.put(KEY_TRACE_ID, traceId.toString());
  }

  public static void setExtTraceId(String extTraceId) {
    MDC.put(KEY_EXT_TRACE_ID, extTraceId);
  }

  public static void setExtValue(String key, String value) {
    MDC.put(key, value);
    if (!extKeySet.contains(key)) {
      extKeySet.add(key);
    }
  }

  public static void setExtMap(Map<String, String> extMap) {
    for (Entry<String, String> entry : extMap.entrySet()) {
      setExtValue(entry.getKey(), entry.getValue());
    }
  }

  public static void setEntityId(Serializable entityId) {
    if (entityId == null) {
      return;
    }
    MDC.put(KEY_ENTITY_ID, entityId.toString());
  }

  public static void setTransactionId(Serializable transactionId) {
    if (transactionId == null) {
      return;
    }
    MDC.put(KEY_TRANSACTION_ID, transactionId.toString());
  }

  public static void reset() {
    MDC.clear();
  }

  public static UUID getTraceId() {
    String value = MDC.get(KEY_TRACE_ID);
    if (value == null) {
      return null;
    }
    return UUID.fromString(value);
  }

  public static String getExtTraceId() {
    return MDC.get(KEY_EXT_TRACE_ID);
  }

  public static Map<String, String> getExtMap() {
    Map<String, String> map = new HashMap<>();
    for (String key : extKeySet) {
      map.put(key, getExtValue(key));
    }
    return map;
  }

  public static String getExtValue(String key) {
    return MDC.get(key);
  }

  public static String decoratePrefix(String msg) {
    StringBuilder buf = new StringBuilder();
    String trace = MDC.get(KEY_TRACE_ID);
    if (trace != null) {
      buf.append("[").append(trace).append("]");
    }
    if (msg != null) {
      buf.append(msg);
    }
    return buf.toString();
  }

  public static void setTenant(String tenant) {
    if (tenant != null) {
      TraceContext.setExtValue(KEY_EXT_TENANT, tenant);
    }
  }
}
