package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentExtensionRepository extends JpaRepository<TAgentExtension, String>, JpaSpecificationExecutor<TAgentExtension> {

}