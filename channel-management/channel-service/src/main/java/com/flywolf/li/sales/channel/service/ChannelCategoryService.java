package com.flywolf.li.sales.channel.service;

import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;

import java.util.List;

public interface ChannelCategoryService {
    public Long register(ChannelCategoryBO bo);
    public void update(ChannelCategoryBO bo);
    public List<ChannelCategoryBO> list();
    public ChannelCategoryBO findById(Long id);
    public ChannelCategoryBO findByCode(String code);
}
