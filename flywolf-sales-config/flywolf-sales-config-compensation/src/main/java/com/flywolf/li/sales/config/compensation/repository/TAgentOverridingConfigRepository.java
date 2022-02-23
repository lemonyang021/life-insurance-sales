package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentOverridingConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentOverridingConfigRepository extends JpaRepository<TAgentOverridingConfig, String>, JpaSpecificationExecutor<TAgentOverridingConfig> {

}