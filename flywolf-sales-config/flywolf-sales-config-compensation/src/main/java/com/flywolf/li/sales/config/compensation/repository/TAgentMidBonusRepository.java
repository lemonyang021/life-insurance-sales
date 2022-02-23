package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentMidBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentMidBonusRepository extends JpaRepository<TAgentMidBonus, String>, JpaSpecificationExecutor<TAgentMidBonus> {

}