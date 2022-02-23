package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentBonusFeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentBonusFeeDetailRepository extends JpaRepository<TAgentBonusFeeDetail, String>, JpaSpecificationExecutor<TAgentBonusFeeDetail> {

}