package com.flywolf.li.sales.channel.dto.req;

import com.flywolf.li.sales.channel.dto.base.ChannelBaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "创建渠道请求对象")
public class RegisterChannelRequest extends ChannelBaseRequest {

    private static final long serialVersionUID = -5499559626737713119L;
}
