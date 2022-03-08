package com.flywolf.li.sales.config.channel.dto;

import com.flywolf.li.framework.dto.GenericLiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(name = "渠道创建结果",description = "渠道创建结果对象")
public class RegisterChannelResponse extends GenericLiResponse {

}
