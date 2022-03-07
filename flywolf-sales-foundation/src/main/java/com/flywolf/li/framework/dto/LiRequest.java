package com.flywolf.li.framework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public interface LiRequest extends IExtendableDTO {

    @Schema(title = "外部交易流水号")
    String getClientRequestId();

    @Schema(title = "外部请求时间")
    Date getClientRequestTime();

    @JsonIgnore
    @Schema(hidden = true)
    Date getServiceReqTime();
}
