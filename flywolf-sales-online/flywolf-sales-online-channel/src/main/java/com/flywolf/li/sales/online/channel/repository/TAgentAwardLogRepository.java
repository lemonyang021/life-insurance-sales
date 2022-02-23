package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAwardLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAwardLogRepository extends JpaRepository<TAgentAwardLog, String>, JpaSpecificationExecutor<TAgentAwardLog> {

}