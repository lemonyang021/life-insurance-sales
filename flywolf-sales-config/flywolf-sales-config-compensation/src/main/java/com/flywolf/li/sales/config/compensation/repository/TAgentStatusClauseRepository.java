package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentStatusClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentStatusClauseRepository extends JpaRepository<TAgentStatusClause, String>, JpaSpecificationExecutor<TAgentStatusClause> {

}