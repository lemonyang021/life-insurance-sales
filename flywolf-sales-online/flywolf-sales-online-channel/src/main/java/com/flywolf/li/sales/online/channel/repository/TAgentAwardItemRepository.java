package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAwardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAwardItemRepository extends JpaRepository<TAgentAwardItem, String>, JpaSpecificationExecutor<TAgentAwardItem> {

}