package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentActivityRecordRepository extends JpaRepository<TAgentActivityRecord, String>, JpaSpecificationExecutor<TAgentActivityRecord> {

}