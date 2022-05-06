package com.flywolf.li.sales.channel.service.impl;

import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.entity.Channel;
import com.flywolf.li.sales.channel.entity.ChannelCategory;
import com.flywolf.li.sales.channel.repository.ChannelRepository;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.service.bo.ChannelBO;
import com.flywolf.li.sales.channel.service.bo.QueryBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 渠道服务实现类
 */
@Service
@Slf4j
public class ChannelServiceImpl implements ChannelService {

    @Resource
    ChannelRepository channelRepository;

    @Override
    public Long register(ChannelBO bo) {
        ChannelCategory channelCategory = ConvertUtil.convert(bo.getChannelCategoryBO(), ChannelCategory.class);
        ConvertUtil.initInsertEntity(channelCategory);
        Channel channel = ConvertUtil.convert(bo, Channel.class);
        ConvertUtil.initInsertEntity(channel);
        channel.setChannelCategory(channelCategory);
        log.info("ChannelBO={},Channel={}", bo, channel);
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

    @Override
    public List<ChannelBO> query(QueryBO bo) {
        /*
         * 泛型是查询的对象，Specification实际上是一个封装了查询规则的查询对象
         * 注意：Specification其实就是对hibernatejpa QBC查询方式的封装，
         * 其中包括，CriteriaBuilder,CriteriaQuery
         * Root,Predicate对像；由于Specification是一个接口类型
         * 所以使用匿名内部类的方式进行实现这个接口，让它回调toPredicate方法
         * test1
         * test2
         */
        Specification<Channel> specification = new Specification<Channel>() {
            /*
             * Predicate对象封装了要查询的条件 root是查询的根对象，对要查询的对象进行一个二次封装，方便去数据库中的各个字段
             * CriteriaQuery<?>封装了一个基本的查询 select* from对象名；
             * CriteriaBuilder创建查询，创建CriteriaQuery<?>对象
             */

            @Override
            public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // 设置多个查询条件
                List<Predicate> list = new ArrayList<>();
                //查询Channel表
                if (StringUtils.isNotBlank(bo.getChannelName())) {
                    list.add(criteriaBuilder.equal(root.get("channelName"), bo.getChannelName()));
                }
                if (StringUtils.isNotBlank(bo.getChannelCode())) {
                    list.add(criteriaBuilder.equal(root.get("channelCode"), bo.getChannelCode()));
                }
                // 使用INNER连接ChannelCategory表查询
                Join<Channel, ChannelCategory> channelCategoryJoin = root.join("channelCategory", JoinType.INNER);
                if (StringUtils.isNotBlank(bo.getCategoryCode())) {
                    list.add(criteriaBuilder.equal(channelCategoryJoin.get("categoryCode"), bo.getCategoryCode()));
                }
                if (StringUtils.isNotBlank(bo.getCategoryName())) {
                    list.add(criteriaBuilder.equal(channelCategoryJoin.get("categoryName"), bo.getCategoryName()));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        List<Channel> channelList = channelRepository.findAll(specification);
        return ConvertUtil.convert(channelList, ChannelBO.class);
    }
}
