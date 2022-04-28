package com.flywolf.li.sales.channel.repository;

import com.flywolf.li.sales.channel.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author flywolf
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>, JpaSpecificationExecutor<Channel> {
    /**
     * @param channelName
     * @return
     */
    Channel findByChannelName(String channelName);

    /**
     * @param channelCode
     * @return
     */
    Channel findByChannelCode(String channelCode);

}
