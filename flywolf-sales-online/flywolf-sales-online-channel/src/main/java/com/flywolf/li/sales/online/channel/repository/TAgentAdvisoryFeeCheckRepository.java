package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAdvisoryFeeCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAdvisoryFeeCheckRepository extends JpaRepository<TAgentAdvisoryFeeCheck, String>, JpaSpecificationExecutor<TAgentAdvisoryFeeCheck> {

}