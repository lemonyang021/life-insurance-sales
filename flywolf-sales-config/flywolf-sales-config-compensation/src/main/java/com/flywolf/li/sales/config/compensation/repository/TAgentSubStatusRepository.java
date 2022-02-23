package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentSubStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentSubStatusRepository extends JpaRepository<TAgentSubStatus, String>, JpaSpecificationExecutor<TAgentSubStatus> {

}