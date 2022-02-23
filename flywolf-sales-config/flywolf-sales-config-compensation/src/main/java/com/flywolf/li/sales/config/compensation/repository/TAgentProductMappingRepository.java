package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentProductMappingRepository extends JpaRepository<TAgentProductMapping, String>, JpaSpecificationExecutor<TAgentProductMapping> {

}