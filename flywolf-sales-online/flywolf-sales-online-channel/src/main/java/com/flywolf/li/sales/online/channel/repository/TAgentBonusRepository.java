package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusRepository extends JpaRepository<TAgentBonus, String>, JpaSpecificationExecutor<TAgentBonus> {

}