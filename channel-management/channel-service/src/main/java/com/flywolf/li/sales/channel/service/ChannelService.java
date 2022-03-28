package com.flywolf.li.sales.channel.service;


import com.flywolf.li.sales.channel.service.bo.ChannelBO;

import java.util.List;

public interface ChannelService {

    public Long register(ChannelBO bo);

    public void update(ChannelBO bo);

    public ChannelBO get(Long channelId);

    public List<ChannelBO> findAll();
}
