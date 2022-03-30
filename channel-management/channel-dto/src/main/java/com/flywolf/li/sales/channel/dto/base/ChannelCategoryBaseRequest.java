package com.flywolf.li.sales.channel.dto.base;

import com.flywolf.li.framework.dto.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelCategoryBaseRequest extends Request {
    private static final long serialVersionUID = 5035069472037176952L;
    @Schema(title = "渠道种类编号")
    @NotBlank(message = "渠道种类编号不能为空")
    @NotNull(message = "渠道种类编号不能为空")
    private String categoryCode;

    @Schema(title = "渠道种类名称")
    @NotBlank(message = "渠道种类名称不能为空")
    @NotNull(message = "渠道种类名称不能为空")
    private String categoryName;
}
