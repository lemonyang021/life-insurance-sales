package com.flywolf.li.framework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public interface LiResponse extends ClientServiceResponse {

  @Schema(title = "外部交易流水号")
  String getClientRequestId();

  @Schema(title = "外部请求时间")
  Date getClientRequestTime();

  @Schema(title = "请求结果<br>1 - 业务成功<br>0 - 业务失败<br>-1 - 程序异常", example="1")
  int getResult();

  @Schema(title = "业务失败原因描述列表节点")
  GenericValidationResult[] getMessages();

  @Schema(title = "异常信息")
  String[] getExceptions();

  @JsonIgnore
  @Schema(hidden = true)
  Date getServiceReqTime();

  @Schema(title="服务器响应时间")
  Date getServiceResTime();

}
