package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusCrAc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusCrAcRepository extends JpaRepository<TAgentBonusCrAc, String>, JpaSpecificationExecutor<TAgentBonusCrAc> {

}