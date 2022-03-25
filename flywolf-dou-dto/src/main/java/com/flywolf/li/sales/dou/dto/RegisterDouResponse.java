package com.flywolf.li.sales.dou.dto;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "分销组织创建结果",description = "分销组织创建结果")
public class RegisterDouResponse extends Response {
    private static final long serialVersionUID = -3615229758831927827L;
    @Schema(title = "分销组织id")
    private Long id;
}
