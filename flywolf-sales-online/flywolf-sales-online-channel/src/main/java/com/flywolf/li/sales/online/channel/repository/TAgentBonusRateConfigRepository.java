package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusRateConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusRateConfigRepository extends JpaRepository<TAgentBonusRateConfig, String>, JpaSpecificationExecutor<TAgentBonusRateConfig> {

}