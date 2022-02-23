package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLeaderHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLeaderHisRepository extends JpaRepository<TAgentLeaderHis, String>, JpaSpecificationExecutor<TAgentLeaderHis> {

}