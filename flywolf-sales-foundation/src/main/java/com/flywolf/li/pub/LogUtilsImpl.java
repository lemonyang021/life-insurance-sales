package com.flywolf.li.pub;

import com.ebao.li.flywolf.sales.dto.generic.ClientServiceResponse;
import com.ebao.li.flywolf.sales.dto.generic.GenericLiResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LogUtilsImpl implements LogUtils {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LogUtilsImpl.class);

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void logResponse(GenericLiResponse response) {
    try {
      if (response == null) {
        logger.error("null response");
        return;
      }
      if (response.getResult() == ClientServiceResponse.ServiceResultCode.SUCCEEDED.code()) {
        logger.trace("transaction finished[status:{}]",
            ClientServiceResponse.ServiceResultCode.forValue(response.getResult()));
      } else if (response.getResult() == ClientServiceResponse.ServiceResultCode.FAILED.code()) {
        if (logger.isWarnEnabled()) {
          logger.warn("transaction failed[status:{}; message:{}]",
              ClientServiceResponse.ServiceResultCode.forValue(response.getResult()),
              objectMapper.writeValueAsString(response.getMessages()));
        }
      } else if (response.getResult() == ClientServiceResponse.ServiceResultCode.EXCEPTION.code()
          && logger.isErrorEnabled()) {
        logger.error("transaction failed[status:{}; message:{}]",
            ClientServiceResponse.ServiceResultCode.forValue(response.getResult()),
            objectMapper.writeValueAsString(response.getExceptions()));
      }
    } catch (JsonProcessingException e) {
      logger.error("", e);
    }

  }

  @Override
  public String getResponseMessage(GenericLiResponse response) {
    try {
      if (response == null) {
        return null;
      }
      if (response.getResult() == ClientServiceResponse.ServiceResultCode.FAILED.code()) {
        return objectMapper.writeValueAsString(response.getMessages());
      } else if (response.getResult() == ClientServiceResponse.ServiceResultCode.EXCEPTION.code()) {
        return objectMapper.writeValueAsString(response.getExceptions());
      }
    } catch (JsonProcessingException e) {
      logger.error("", e);
    }
    return "";
  }



}
