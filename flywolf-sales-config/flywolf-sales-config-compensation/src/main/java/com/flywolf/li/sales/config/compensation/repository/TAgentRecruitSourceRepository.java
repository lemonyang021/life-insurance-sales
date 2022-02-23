package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentRecruitSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentRecruitSourceRepository extends JpaRepository<TAgentRecruitSource, String>, JpaSpecificationExecutor<TAgentRecruitSource> {

}