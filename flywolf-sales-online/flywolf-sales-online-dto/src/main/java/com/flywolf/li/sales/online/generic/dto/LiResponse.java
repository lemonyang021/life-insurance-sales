package com.flywolf.li.sales.online.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public interface LiResponse extends ClientServiceResponse {

  @ApiModelProperty(value = "外部交易流水号", position = -100)
  String getClientRequestId();

  @ApiModelProperty(value = "外部请求时间", position = -99)
  Date getClientRequestTime();

  @ApiModelProperty(value = "请求结果<br>1 - 业务成功<br>0 - 业务失败<br>-1 - 程序异常", example="1", position = -98)
  int getResult();

  @ApiModelProperty(value = "业务失败原因描述列表节点", position = -97)
  GenericValidationResult[] getMessages();

  @ApiModelProperty(value = "异常信息", position = -96)
  String[] getExceptions();

  @JsonIgnore
  @ApiModelProperty(hidden = true)
  Date getServiceReqTime();

  @JsonIgnore
  @ApiModelProperty(hidden = true)
  Date getServiceResTime();

}
