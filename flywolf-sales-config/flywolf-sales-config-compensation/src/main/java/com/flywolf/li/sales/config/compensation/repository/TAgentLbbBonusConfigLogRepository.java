package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLbbBonusConfigLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLbbBonusConfigLogRepository extends JpaRepository<TAgentLbbBonusConfigLog, String>, JpaSpecificationExecutor<TAgentLbbBonusConfigLog> {

}