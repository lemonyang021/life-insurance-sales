package com.flywolf.li.framework.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Date;

public interface ClientServiceResponse extends java.io.Serializable {
  void setClientRequestId(String clientRequestId);

  String getClientRequestId();

  void setClientRequestTime(Date clientRequestTime);

  Date getClientRequestTime();

  void setServiceReqTime(Date startTime);

  Date getServiceReqTime();

  void setServiceResTime(Date endTime);

  Date getServiceResTime();

  void setResult(ServiceResultCode result);

  int getResult();

  void setMessages(GenericValidationResult[] messages);

  GenericValidationResult[] getMessages();

  void setExceptions(String[] exceptions);

  String[] getExceptions();

  String getTraceId();

  public enum ServiceResultCode {
    SUCCEEDED(1), FAILED(0), EXCEPTION(-1);
    private int code;

    private ServiceResultCode(int code) {
      this.code = code;
    }

    public int code() {
      return this.code;
    }

    @JsonValue
    public int toValue() {
      return this.code;
    }

    @JsonCreator
    public static ServiceResultCode forValue(int code) {
      ServiceResultCode[] values = ServiceResultCode.values();
      for (ServiceResultCode value : values) {
        if (value.code == code) {
          return value;
        }
      }
      return EXCEPTION;
    }
  }
}
