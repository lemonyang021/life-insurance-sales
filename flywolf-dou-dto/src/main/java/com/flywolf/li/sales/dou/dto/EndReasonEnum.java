package com.flywolf.li.sales.dou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum EndReasonEnum {

    /**
     * 业务处理成功
     */
    bankruptcy(1, "破产"),
    /**
     * 参数错误
     */
    low_performance(2, "业绩不达标"),
    /**
     * 参数错误
     */
    supervisor_resigns(3, "主管离职"),
    ;


    private final Integer code;
    private final String desc;

    /**
     * 根据代码获取枚举
     *
     * @param code
     * @return RespCodeEnum
     */
    public static EndReasonEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(v -> Objects.equals(code, v.getCode())).findAny().orElse(null);
    }
}
