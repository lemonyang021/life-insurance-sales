package com.flywolf.li.sales.channel.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
/**
 * 渠道种类业务对象
 */
public class ChannelCategoryBO extends BaseBO {
    /**
     * 渠道种类id
     */
    private Long id;
    /**
     * 渠道种类编号
     */
    private String categoryCode;
    /**
     * 渠道种类名称
     */
    private String categoryName;
}
