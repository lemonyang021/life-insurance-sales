package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusCheckInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusCheckInfoRepository extends JpaRepository<TAgentBonusCheckInfo, String>, JpaSpecificationExecutor<TAgentBonusCheckInfo> {

}