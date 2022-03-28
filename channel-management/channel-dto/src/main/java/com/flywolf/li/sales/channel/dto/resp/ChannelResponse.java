package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelResponse extends Response {
    private static final long serialVersionUID = 6728844324974843661L;

    @Schema(title = "渠道名称", required = true)
    private String channelName;
    @Schema(title = "渠道代号", required = true)
    private String channelCode;
    @Schema(title = "渠道种类", required = true)
    private String categoryCode;
}
