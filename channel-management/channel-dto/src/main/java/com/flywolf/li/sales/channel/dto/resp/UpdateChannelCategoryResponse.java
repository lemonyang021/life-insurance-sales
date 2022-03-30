package com.flywolf.li.sales.channel.dto.resp;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "渠道种类更新结果对象",description = "渠道种类更新结果对象")
public class UpdateChannelCategoryResponse extends Response {
    private static final long serialVersionUID = 7596215993064803303L;
}
