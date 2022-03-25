package com.flywolf.li.sales.dou.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "分销组织信息",description = "分销组织信息")
public class DouResponse extends Dou{
    private static final long serialVersionUID = 8252780504502090395L;
    @Schema(title = "分销组织id")
    @NotNull(message = "分销组织id不能为空")
    @NotBlank(message = "分销组织id不能为空")
    private Long id;
}
