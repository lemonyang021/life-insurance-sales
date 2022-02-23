package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentOverridingConfigLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentOverridingConfigLogRepository extends JpaRepository<TAgentOverridingConfigLog, String>, JpaSpecificationExecutor<TAgentOverridingConfigLog> {

}