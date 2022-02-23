package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAdvisRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAdvisRateRepository extends JpaRepository<TAgentAdvisRate, String>, JpaSpecificationExecutor<TAgentAdvisRate> {

}