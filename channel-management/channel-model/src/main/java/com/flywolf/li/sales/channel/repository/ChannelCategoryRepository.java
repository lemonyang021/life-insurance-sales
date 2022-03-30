package com.flywolf.li.sales.channel.repository;

import com.flywolf.li.sales.channel.entity.ChannelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChannelCategoryRepository extends JpaRepository<ChannelCategory, Long>, JpaSpecificationExecutor<ChannelCategory> {
    ChannelCategory findByCategoryCode(String categoryCode);
}