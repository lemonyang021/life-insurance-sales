package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentStatusReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentStatusReasonRepository extends JpaRepository<TAgentStatusReason, String>, JpaSpecificationExecutor<TAgentStatusReason> {

}