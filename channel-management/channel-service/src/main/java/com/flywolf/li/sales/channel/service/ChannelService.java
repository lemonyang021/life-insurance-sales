package com.flywolf.li.sales.channel.service;


import com.flywolf.li.sales.channel.service.bo.ChannelBO;

import java.util.List;

/**
 * 渠道服务
 */
public interface ChannelService {

    /**
     * 注册渠道
     * @param bo
     * @return
     */
    public Long register(ChannelBO bo);

    /**
     * 更新渠道
     * @param bo
     */
    public void update(ChannelBO bo);

    /**
     * 根据渠道id获取渠道信息
     * @param channelId
     * @return
     */
    public ChannelBO get(Long channelId);

    /**
     * 获取所有渠道信息
     * @return
     */
    public List<ChannelBO> findAll();
}
