package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentTransferReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentTransferReasonRepository extends JpaRepository<TAgentTransferReason, String>, JpaSpecificationExecutor<TAgentTransferReason> {

}