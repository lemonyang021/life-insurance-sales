package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusRo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusRoRepository extends JpaRepository<TAgentBonusRo, String>, JpaSpecificationExecutor<TAgentBonusRo> {

}