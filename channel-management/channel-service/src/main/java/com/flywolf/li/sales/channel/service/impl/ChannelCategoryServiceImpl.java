package com.flywolf.li.sales.channel.service.impl;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.entity.ChannelCategory;
import com.flywolf.li.sales.channel.repository.ChannelCategoryRepository;
import com.flywolf.li.sales.channel.service.ChannelCategoryService;
import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelCategoryServiceImpl implements ChannelCategoryService {
    @Resource
    ChannelCategoryRepository channelCategoryRepository;

    @Override
    public Long register(ChannelCategoryBO bo) {
        ChannelCategory channelCategory = ConvertUtil.convert(bo, ChannelCategory.class);
        ConvertUtil.initInsertEntity(channelCategory);
        channelCategoryRepository.save(channelCategory);
        return channelCategory.getId();
    }

    @Override
    public void update(ChannelCategoryBO bo) {
        ChannelCategory channelCategory = ConvertUtil.convert(bo, ChannelCategory.class);
        ConvertUtil.initUpdateEntity(channelCategory);
        channelCategoryRepository.save(channelCategory);
    }

    @Override
    public List<ChannelCategoryBO> list() {
        List<ChannelCategory> channelCategoryList = channelCategoryRepository.findAll();
        return ConvertUtil.convert(channelCategoryList, ChannelCategoryBO.class);
    }

    @Override
    public ChannelCategoryBO findById(Long id) {
        return ConvertUtil.convert(channelCategoryRepository.findById(id).get(), ChannelCategoryBO.class);
    }

    @Override
    public ChannelCategoryBO findByCode(String code) {
        return ConvertUtil.convert(channelCategoryRepository.findByCategoryCode(code), ChannelCategoryBO.class);
    }
}
