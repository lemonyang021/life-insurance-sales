package com.flywolf.li.sales.config.channel.service;


import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;

public interface ChannelConfigService {

    public Long register(RegisterChannelRequest request);

    public void update(RegisterChannelRequest request);
}
