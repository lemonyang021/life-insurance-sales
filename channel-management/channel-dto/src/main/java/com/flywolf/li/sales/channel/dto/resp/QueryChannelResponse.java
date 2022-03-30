package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QueryChannelResponse extends Response {
    private static final long serialVersionUID = -5604032260680713152L;
    @Schema(title = "渠道id",required = true)
    private Integer id;
    @Schema(title = "渠道名称", required = true)
    private String channelName;
    @Schema(title = "渠道代号", required = true)
    private String channelCode;
    @Schema(title = "渠道种类", required = true)
    private String categoryCode;
    @Schema(title = "渠道种类描述", required = true)
    private String categoryName;
}
