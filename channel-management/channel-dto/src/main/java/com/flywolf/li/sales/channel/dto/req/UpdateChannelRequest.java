package com.flywolf.li.sales.channel.dto.req;

import com.flywolf.li.sales.channel.dto.base.ChannelBaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "更新渠道请求对象")
public class UpdateChannelRequest extends ChannelBaseRequest {
    private static final long serialVersionUID = -9080652934096513194L;

    @Schema(title = "渠道id")
    @NotNull(message = "渠道种类id不能为空")
    @NotBlank(message = "渠道种类id不能为空")
    private Long id;
}
