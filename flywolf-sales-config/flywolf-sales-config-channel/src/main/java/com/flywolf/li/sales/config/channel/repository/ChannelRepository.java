package com.flywolf.li.sales.config.channel.repository;

import com.flywolf.li.sales.config.channel.data.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChannelRepository extends JpaRepository<Channel, String>, JpaSpecificationExecutor<Channel> {
    Channel findByChannelName(String channelName);

    Channel findByChannelCode(String channelCode);

}
