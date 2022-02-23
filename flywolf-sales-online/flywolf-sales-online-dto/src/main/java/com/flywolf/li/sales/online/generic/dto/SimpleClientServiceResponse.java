package com.flywolf.li.sales.online.generic.dto;

import java.util.Date;


public class SimpleClientServiceResponse extends GenericOVO implements ClientServiceResponse {

  private static final long serialVersionUID = 1968676876022358057L;

  private String clientRequestId;
  private Date clientRequestTime;
  private ServiceResultCode result;
  private GenericValidationResult[] messages;
  private String[] exceptions;
  private Date serviceReqTime;
  private Date serviceResTime;
  private String traceId;
}
