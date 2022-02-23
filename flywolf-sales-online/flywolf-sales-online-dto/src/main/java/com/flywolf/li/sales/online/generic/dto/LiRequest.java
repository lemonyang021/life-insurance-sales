package com.flywolf.li.sales.online.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public interface LiRequest extends IExtendableDTO {

    @ApiModelProperty(value = "外部交易流水号", position = -100)
    String getClientRequestId();

    @ApiModelProperty(value = "外部请求时间", position = -99)
    Date getClientRequestTime();

    @JsonIgnore
    @ApiModelProperty(hidden = true, position = -98)
    Date getServiceReqTime();
}
