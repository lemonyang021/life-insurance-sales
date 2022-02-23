package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentComOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentComOverrideRepository extends JpaRepository<TAgentComOverride, String>, JpaSpecificationExecutor<TAgentComOverride> {

}