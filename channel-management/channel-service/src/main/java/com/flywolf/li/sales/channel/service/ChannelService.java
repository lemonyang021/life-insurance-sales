package com.flywolf.li.sales.channel.service;


import com.flywolf.li.sales.channel.dto.RegisterChannelRequest;

public interface ChannelService {

    public Long register(RegisterChannelRequest request);

    public void update(RegisterChannelRequest request);
}
