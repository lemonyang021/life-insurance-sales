package com.flywolf.li.framework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4723887430773820881L;
    @Schema(title = "返回码")
    private String code;

    @Schema(title = "返回信息")
    private String msg;

    @Schema(title = "返回数据")
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc(), data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc(), null);
    }

    public static <T> Result<T> error(String code, String message) {
        return new Result<T>(code, message, null);
    }
}
