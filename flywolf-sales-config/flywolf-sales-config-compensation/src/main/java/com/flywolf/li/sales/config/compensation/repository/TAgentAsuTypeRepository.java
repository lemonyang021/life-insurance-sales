package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAsuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAsuTypeRepository extends JpaRepository<TAgentAsuType, String>, JpaSpecificationExecutor<TAgentAsuType> {

}