package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentOverridingConfigC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentOverridingConfigCRepository extends JpaRepository<TAgentOverridingConfigC, Void>, JpaSpecificationExecutor<TAgentOverridingConfigC> {

}