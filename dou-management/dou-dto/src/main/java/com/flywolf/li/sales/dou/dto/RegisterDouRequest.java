package com.flywolf.li.sales.dou.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "分销组织创建请求",description = "分销组织创建请求")
public class RegisterDouRequest extends Dou {
    private static final long serialVersionUID = -5499559626737713119L;
}
