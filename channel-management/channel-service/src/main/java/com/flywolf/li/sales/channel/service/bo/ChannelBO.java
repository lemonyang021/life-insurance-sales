package com.flywolf.li.sales.channel.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelBO extends BaseBO {

    private Long id;

    private String channelName;

    private String channelCode;

    private String categoryCode;
}
