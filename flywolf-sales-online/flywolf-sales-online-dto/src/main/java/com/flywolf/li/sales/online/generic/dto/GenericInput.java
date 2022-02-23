package com.flywolf.li.sales.online.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)//忽略类中不存在的字段
@JsonInclude(JsonInclude.Include.NON_EMPTY)//内容不为空的字段才进行json转化
public interface GenericInput extends GenericValueObject {
}
