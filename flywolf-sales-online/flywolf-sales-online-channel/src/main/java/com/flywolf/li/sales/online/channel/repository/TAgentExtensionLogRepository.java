package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentExtensionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentExtensionLogRepository extends JpaRepository<TAgentExtensionLog, String>, JpaSpecificationExecutor<TAgentExtensionLog> {

}