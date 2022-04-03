package com.flywolf.li.sales.channel.service;

import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;

import java.util.List;

/**
 * 渠道种类服务
 */
public interface ChannelCategoryService {
    /**
     * 注册渠道种类
     * @param bo
     * @return
     */
    public Long register(ChannelCategoryBO bo);

    /**
     * 更新渠道种类
     * @param bo
     */
    public void update(ChannelCategoryBO bo);

    /**
     * 获取所有渠道种类
     * @return
     */
    public List<ChannelCategoryBO> list();

    /**
     * 根据渠道种类id获取信息
     * @param id
     * @return
     */
    public ChannelCategoryBO findById(Long id);

    /**
     * 根据渠道种类编号获取信息
     * @param code
     * @return
     */
    public ChannelCategoryBO findByCode(String code);
}
