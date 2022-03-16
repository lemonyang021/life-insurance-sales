package com.flywolf.li.framework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class Request implements Serializable {


    private static final long serialVersionUID = 181444676866573110L;
    @Schema(title = "请求流水号")
    private String reqNo = UUID.randomUUID().toString().replace("-", "");

    @Schema(title = "请求时间")
    private Date reqTime;

    @Schema(title = "请求语种")
    private String langCode;
}
