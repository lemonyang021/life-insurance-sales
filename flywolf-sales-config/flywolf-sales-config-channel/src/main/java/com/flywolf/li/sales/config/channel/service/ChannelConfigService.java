package com.flywolf.li.sales.config.channel.service;


import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;

public interface ChannelConfigService {

    boolean register(RegisterChannelRequest request);
}
