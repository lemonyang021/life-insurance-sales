package com.flywolf.li.framework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -3999265661002138941L;

    @Schema(title = "请求码")
    private String reqNo;


}