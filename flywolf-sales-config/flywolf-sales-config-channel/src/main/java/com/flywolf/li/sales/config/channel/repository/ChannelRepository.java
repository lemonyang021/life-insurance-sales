package com.flywolf.li.sales.config.channel.repository;

import com.flywolf.li.sales.config.channel.data.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, UUID>, JpaSpecificationExecutor<Channel> {
    Channel findByChannelName(String channelName);

    Channel findByChannelCode(String channelCode);

}
