package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentTerminateMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentTerminateMappingRepository extends JpaRepository<TAgentTerminateMapping, Void>, JpaSpecificationExecutor<TAgentTerminateMapping> {

}