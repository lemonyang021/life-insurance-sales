package com.flywolf.li.sales.online.channel.service;

import com.flywolf.li.framework.web.ServiceHeader;
import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;


public interface ChannelService {

    void create(ServiceHeader serviceHeader, String insurerCode,
                CreateChannelRequest request);

}
