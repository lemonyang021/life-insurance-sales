package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentQueryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentQueryTypeRepository extends JpaRepository<TAgentQueryType, String>, JpaSpecificationExecutor<TAgentQueryType> {

}