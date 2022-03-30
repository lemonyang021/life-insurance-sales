package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterChannelCategoryResponse extends Response {
    private static final long serialVersionUID = 3994087310577927666L;
    @Schema(title = "渠道种类id")
    private Long id;
}
