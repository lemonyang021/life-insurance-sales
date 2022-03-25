package com.flywolf.li.sales.channel.service;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.channel.entity.Channel;
import com.flywolf.li.sales.channel.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChannelServiceImpl implements ChannelService {

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
    }
}
