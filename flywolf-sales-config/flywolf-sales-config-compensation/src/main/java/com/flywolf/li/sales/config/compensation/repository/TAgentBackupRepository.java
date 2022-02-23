package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBackupRepository extends JpaRepository<TAgentBackup, String>, JpaSpecificationExecutor<TAgentBackup> {

}