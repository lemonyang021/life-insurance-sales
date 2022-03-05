package com.flywolf.li.sales.config.channel.service;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.config.channel.data.Channel;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class ChannelConfigServiceImpl implements ChannelConfigService {

   @Resource
    ChannelRepository channelRepository;

    @Override
    public boolean register(RegisterChannelRequest request) {
        Channel channel = ConvertUtil.convert(request, Channel.class);
        channel.setId(UUID.randomUUID());
        channelRepository.save(channel);
        return true;
    }
}
