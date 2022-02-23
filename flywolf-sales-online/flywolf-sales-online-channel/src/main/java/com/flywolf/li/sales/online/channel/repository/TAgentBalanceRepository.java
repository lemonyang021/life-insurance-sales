package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBalanceRepository extends JpaRepository<TAgentBalance, String>, JpaSpecificationExecutor<TAgentBalance> {

}