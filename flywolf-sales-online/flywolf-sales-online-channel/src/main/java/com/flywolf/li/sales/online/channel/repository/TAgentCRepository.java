package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentCRepository extends JpaRepository<TAgentC, Void>, JpaSpecificationExecutor<TAgentC> {

}