package com.flywolf.li.sales.online.generic.dto;

import java.util.Date;

public interface ClientServiceRequest extends java.io.Serializable {
  String getClientRequestId();

  Date getClientRequestTime();

  void setServiceReqTime(Date startTime);

  Date getServiceReqTime();
}
