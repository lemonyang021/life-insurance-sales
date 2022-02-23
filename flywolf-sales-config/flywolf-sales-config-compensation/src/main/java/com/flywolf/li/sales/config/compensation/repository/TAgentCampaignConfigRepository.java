package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentCampaignConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentCampaignConfigRepository extends JpaRepository<TAgentCampaignConfig, String>, JpaSpecificationExecutor<TAgentCampaignConfig> {

}