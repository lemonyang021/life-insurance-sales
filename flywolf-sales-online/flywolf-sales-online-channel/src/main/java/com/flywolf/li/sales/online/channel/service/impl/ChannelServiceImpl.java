package com.flywolf.li.sales.online.channel.service.impl;

import com.flywolf.li.framework.web.ServiceHeader;
import com.ebao.li.flywolf.sales.online.channel.helper.ChannelConvertHelper;
import com.flywolf.li.sales.online.channel.repository.TAgentCateRepository;
import com.flywolf.li.sales.online.channel.service.ChannelService;
import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private TAgentCateRepository agentCateRepository;
    @Override
    public void create(ServiceHeader serviceHeader, String insurerCode, CreateChannelRequest request) {
        agentCateRepository.save(ChannelConvertHelper.fromChannelDTO(request));
    }
}
