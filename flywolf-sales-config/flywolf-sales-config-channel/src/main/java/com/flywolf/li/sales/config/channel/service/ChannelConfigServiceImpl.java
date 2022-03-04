package com.flywolf.li.sales.config.channel.service;

import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import org.springframework.stereotype.Service;

@Service
public class ChannelConfigServiceImpl implements ChannelConfigService {

    @Override
    public boolean register(RegisterChannelRequest request) {
        return false;
    }
}
