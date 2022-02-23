package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAwardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAwardTypeRepository extends JpaRepository<TAgentAwardType, String>, JpaSpecificationExecutor<TAgentAwardType> {

}