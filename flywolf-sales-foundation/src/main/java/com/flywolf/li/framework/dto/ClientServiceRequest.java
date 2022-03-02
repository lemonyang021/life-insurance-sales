package com.flywolf.li.framework.dto;

import java.util.Date;

public interface ClientServiceRequest extends java.io.Serializable {
  String getClientRequestId();

  Date getClientRequestTime();

  void setServiceReqTime(Date startTime);

  Date getServiceReqTime();
}
