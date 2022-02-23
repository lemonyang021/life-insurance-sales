package com.flywolf.li.framework.web;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class InternalServiceHeader implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -8115349494902947381L;

  public static final String InternalTraceKey = "InternalTraceKey";
  public static final String InternalTraceId = "InternalTraceId";

  private Long userId;
  private String tenant;
  private String traceId;
  private String extTraceId;
  private Map<String, String> extMap = new HashMap<>();

}
