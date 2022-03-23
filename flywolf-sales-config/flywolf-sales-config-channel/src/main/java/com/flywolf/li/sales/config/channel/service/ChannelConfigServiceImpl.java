package com.flywolf.li.sales.config.channel.service;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.entity.Channel;
import com.flywolf.li.sales.config.channel.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChannelConfigServiceImpl implements ChannelConfigService {

    @Resource
    ChannelRepository channelRepository;

    @Override
    public Long register(RegisterChannelRequest request) {
        Channel channel = ConvertUtil.convert(request, Channel.class);
        ConvertUtil.initInsertEntity(channel);
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public void update(RegisterChannelRequest request) {
        Channel channel = ConvertUtil.convert(request, Channel.class);
        ConvertUtil.initInsertEntity(channel);
        channel=channelRepository.findByChannelCode(channel.getChannelCode());
        channel.setChannelCode("judy");
        channel.setChannelName("judy");
        channel.setCategoryCode("judy");
        channelRepository.save(channel);
        int i=1/0;
    }
}
