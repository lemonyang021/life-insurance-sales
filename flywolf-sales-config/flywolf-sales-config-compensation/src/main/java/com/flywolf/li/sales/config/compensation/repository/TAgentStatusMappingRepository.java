package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentStatusMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentStatusMappingRepository extends JpaRepository<TAgentStatusMapping, String>, JpaSpecificationExecutor<TAgentStatusMapping> {

}