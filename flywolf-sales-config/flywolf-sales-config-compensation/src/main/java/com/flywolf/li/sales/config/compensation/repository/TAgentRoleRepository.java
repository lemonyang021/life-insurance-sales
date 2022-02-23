package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentRoleRepository extends JpaRepository<TAgentRole, String>, JpaSpecificationExecutor<TAgentRole> {

}