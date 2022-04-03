package com.flywolf.li.sales.channel.service.impl;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.entity.Channel;
import com.flywolf.li.sales.channel.repository.ChannelRepository;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.service.bo.ChannelBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 渠道服务实现类
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    ChannelRepository channelRepository;

    @Override
    public Long register(ChannelBO bo) {
        Channel channel = ConvertUtil.convert(bo, Channel.class);
        ConvertUtil.initInsertEntity(channel);
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public void update(ChannelBO bo) {
        Channel channel = ConvertUtil.convert(bo, Channel.class);
        ConvertUtil.initInsertEntity(channel);
        channelRepository.save(channel);
    }

    @Override
    public ChannelBO get(Long channelId) {
        Channel channel = channelRepository.findById(channelId).get();
        return ConvertUtil.convert(channel, ChannelBO.class);
    }

    @Override
    public List<ChannelBO> findAll() {
        List<Channel> channelList = channelRepository.findAll();
        return ConvertUtil.convert(channelList, ChannelBO.class);
    }
}
