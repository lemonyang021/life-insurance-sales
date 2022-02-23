package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusRateRepository extends JpaRepository<TAgentBonusRate, String>, JpaSpecificationExecutor<TAgentBonusRate> {

}