package com.flywolf.li.sales.online.channel.service;

import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;


public interface ChannelService {

    void create( String insurerCode,
                CreateChannelRequest request);

}
