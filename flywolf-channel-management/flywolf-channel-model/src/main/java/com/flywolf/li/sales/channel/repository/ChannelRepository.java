package com.flywolf.li.sales.channel.repository;

import com.flywolf.li.sales.channel.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>, JpaSpecificationExecutor<Channel> {
    Channel findByChannelName(String channelName);

    Channel findByChannelCode(String channelCode);

}
