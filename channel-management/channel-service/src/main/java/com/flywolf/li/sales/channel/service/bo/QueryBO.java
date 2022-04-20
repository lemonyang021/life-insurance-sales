package com.flywolf.li.sales.channel.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QueryBO extends BaseBO {

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道编号
     */
    private String channelCode;

    /**
     * 渠道种类代号
     */
    private String categoryCode;

    /**
     * 渠道种类名称
     */
    private String categoryName;
}
