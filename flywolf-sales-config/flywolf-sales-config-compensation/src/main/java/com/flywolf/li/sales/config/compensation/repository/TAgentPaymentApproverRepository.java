package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentPaymentApprover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentPaymentApproverRepository extends JpaRepository<TAgentPaymentApprover, String>, JpaSpecificationExecutor<TAgentPaymentApprover> {

}