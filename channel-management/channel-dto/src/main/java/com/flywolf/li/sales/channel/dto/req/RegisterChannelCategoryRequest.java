package com.flywolf.li.sales.channel.dto.req;

import com.flywolf.li.sales.channel.dto.base.ChannelCategoryBaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "创建渠道种类请求对象")
public class RegisterChannelCategoryRequest extends ChannelCategoryBaseRequest {
    private static final long serialVersionUID = -6722115962990940816L;
}
