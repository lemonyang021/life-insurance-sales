package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusConfigRepository extends JpaRepository<TAgentBonusConfig, String>, JpaSpecificationExecutor<TAgentBonusConfig> {

}