package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAwardC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAwardCRepository extends JpaRepository<TAgentAwardC, Void>, JpaSpecificationExecutor<TAgentAwardC> {

}