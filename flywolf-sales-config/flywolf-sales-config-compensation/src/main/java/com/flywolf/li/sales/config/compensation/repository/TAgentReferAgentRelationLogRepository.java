package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentReferAgentRelationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentReferAgentRelationLogRepository extends JpaRepository<TAgentReferAgentRelationLog, String>, JpaSpecificationExecutor<TAgentReferAgentRelationLog> {

}