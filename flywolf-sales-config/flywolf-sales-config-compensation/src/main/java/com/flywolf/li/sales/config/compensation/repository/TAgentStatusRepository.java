package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentStatusRepository extends JpaRepository<TAgentStatus, String>, JpaSpecificationExecutor<TAgentStatus> {

}