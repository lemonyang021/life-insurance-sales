package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentForbidProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentForbidProductLogRepository extends JpaRepository<TAgentForbidProductLog, String>, JpaSpecificationExecutor<TAgentForbidProductLog> {

}