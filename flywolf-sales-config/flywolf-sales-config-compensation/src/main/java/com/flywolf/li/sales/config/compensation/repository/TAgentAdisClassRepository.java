package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAdisClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAdisClassRepository extends JpaRepository<TAgentAdisClass, String>, JpaSpecificationExecutor<TAgentAdisClass> {

}