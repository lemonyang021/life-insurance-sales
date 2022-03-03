package com.flywolf.li.sales.config.channel.dto;

import com.flywolf.li.framework.dto.GenericLiRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterChannelRequest extends GenericLiRequest {

    @ApiModelProperty(value = "渠道名称", required = true, position = 1)
    private String channelName;
    @ApiModelProperty(value = "渠道代号", required = true, position = 2)
    private String channelCode;
    @ApiModelProperty(value = "渠道种类", required = true, position = 3)
    private String channelCate;
}
