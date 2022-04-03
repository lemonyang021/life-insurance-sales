package com.flywolf.li.sales.channel.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
/**
 * 渠道业务对象
 */
public class ChannelBO extends BaseBO {

    /**
     * 渠道id
     */
    private Long id;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道编号
     */
    private String channelCode;

    /**
     * 渠道种类对象
     */
    private ChannelCategoryBO channelCategoryBO;
}
