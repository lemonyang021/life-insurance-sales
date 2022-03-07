package com.flywolf.li.sales.config.channel.dto;

import com.flywolf.li.framework.dto.GenericLiRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterChannelRequest extends GenericLiRequest {

    @Schema(title = "渠道名称", required = true)
    @NotNull(message = "渠道名称不能为空")
    @NotBlank(message = "渠道名称不能为空")
    private String channelName;
    @NotNull(message = "渠道代号不能为空")
    @NotBlank(message = "渠道代号不能为空")
    @Schema(title = "渠道代号", required = true)
    private String channelCode;
    @NotNull(message = "渠道种类不能为空")
    @NotBlank(message = "渠道种类不能为空")
    @Schema(title = "渠道种类", required = true)
    private String channelCate;
}
