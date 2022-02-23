package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLevelMotherLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLevelMotherLogRepository extends JpaRepository<TAgentLevelMotherLog, String>, JpaSpecificationExecutor<TAgentLevelMotherLog> {

}