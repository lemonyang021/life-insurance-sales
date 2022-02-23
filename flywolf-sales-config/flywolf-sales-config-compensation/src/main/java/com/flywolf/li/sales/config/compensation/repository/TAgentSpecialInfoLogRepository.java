package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentSpecialInfoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentSpecialInfoLogRepository extends JpaRepository<TAgentSpecialInfoLog, String>, JpaSpecificationExecutor<TAgentSpecialInfoLog> {

}