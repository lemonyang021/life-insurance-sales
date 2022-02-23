package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentWelfareStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentWelfareStatusRepository extends JpaRepository<TAgentWelfareStatus, String>, JpaSpecificationExecutor<TAgentWelfareStatus> {

}