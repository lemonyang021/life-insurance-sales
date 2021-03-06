package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "渠道创建结果对象",description = "渠道创建结果对象")
public class RegisterChannelResponse extends Response {
    private static final long serialVersionUID = -3615229758831927827L;
    @Schema(title = "渠道id")
    private Long id;

}
