package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentTerminateReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentTerminateReasonRepository extends JpaRepository<TAgentTerminateReason, String>, JpaSpecificationExecutor<TAgentTerminateReason> {

}