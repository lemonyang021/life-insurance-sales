package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "更新渠道结果对象")
public class UpdateChannelResponse extends Response {
    private static final long serialVersionUID = -7473528360748836845L;
}
