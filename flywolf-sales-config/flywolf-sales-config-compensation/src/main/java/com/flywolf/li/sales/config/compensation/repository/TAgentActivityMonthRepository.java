package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentActivityMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentActivityMonthRepository extends JpaRepository<TAgentActivityMonth, String>, JpaSpecificationExecutor<TAgentActivityMonth> {

}