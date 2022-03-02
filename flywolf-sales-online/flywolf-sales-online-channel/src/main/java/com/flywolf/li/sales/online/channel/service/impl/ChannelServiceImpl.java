package com.flywolf.li.sales.online.channel.service.impl;

import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import com.flywolf.li.sales.online.channel.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    //private TAgentCateRepository agentCateRepository;
    @Override
    public void create(String insurerCode, CreateChannelRequest request) {
        //agentCateRepository.save(ChannelConvertHelper.fromChannelDTO(request));
    }
}
