package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusConfigCrAc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusConfigCrAcRepository extends JpaRepository<TAgentBonusConfigCrAc, String>, JpaSpecificationExecutor<TAgentBonusConfigCrAc> {

}