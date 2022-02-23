package com.flywolf.li.pub;


import com.ebao.li.flywolf.sales.dto.generic.GenericLiResponse;

public interface LogUtils {
  void logResponse(GenericLiResponse response);
  
  String getResponseMessage(GenericLiResponse response);
}
