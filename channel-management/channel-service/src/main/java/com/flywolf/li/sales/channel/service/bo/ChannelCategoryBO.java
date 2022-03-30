package com.flywolf.li.sales.channel.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelCategoryBO extends BaseBO {
    private Long id;
    private String categoryCode;
    private String categoryName;
}
