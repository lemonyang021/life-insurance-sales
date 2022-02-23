package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentStatusClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentStatusClauseRepository extends JpaRepository<TAgentStatusClause, String>, JpaSpecificationExecutor<TAgentStatusClause> {

}