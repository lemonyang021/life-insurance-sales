package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLbbBonusConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLbbBonusConfigRepository extends JpaRepository<TAgentLbbBonusConfig, String>, JpaSpecificationExecutor<TAgentLbbBonusConfig> {

}