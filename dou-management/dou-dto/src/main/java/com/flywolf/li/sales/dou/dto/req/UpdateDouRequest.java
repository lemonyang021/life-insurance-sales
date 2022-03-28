package com.flywolf.li.sales.dou.dto.req;

import com.flywolf.li.sales.dou.dto.base.Dou;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "分销组织更新请求",description = "分销组织更新请求")
public class UpdateDouRequest extends Dou {
    private static final long serialVersionUID = -4319848633931252831L;
    @Schema(title = "分销组织id")
    @NotNull(message = "分销组织id不能为空")
    @NotBlank(message = "分销组织id不能为空")
    private Long id;
}
