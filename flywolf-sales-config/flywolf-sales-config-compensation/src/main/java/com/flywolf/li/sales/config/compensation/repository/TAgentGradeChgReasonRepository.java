package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentGradeChgReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentGradeChgReasonRepository extends JpaRepository<TAgentGradeChgReason, String>, JpaSpecificationExecutor<TAgentGradeChgReason> {

}