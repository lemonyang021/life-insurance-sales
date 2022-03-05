package com.flywolf.li.sales.config.channel.dto;

import com.flywolf.li.framework.dto.GenericLiRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterChannelRequest extends GenericLiRequest {

    @ApiModelProperty(value = "渠道名称", required = true, position = 1)
    @NotNull(message = "渠道名称不能为空")
    @NotBlank(message = "渠道名称不能为空")
    private String channelName;
    @NotNull(message = "渠道代号不能为空")
    @NotBlank(message = "渠道代号不能为空")
    @ApiModelProperty(value = "渠道代号", required = true, position = 2)
    private String channelCode;
    @NotNull(message = "渠道种类不能为空")
    @NotBlank(message = "渠道种类不能为空")
    @ApiModelProperty(value = "渠道种类", required = true, position = 3)
    private String channelCate;
}
