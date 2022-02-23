package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentOldJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentOldJobRepository extends JpaRepository<TAgentOldJob, String>, JpaSpecificationExecutor<TAgentOldJob> {

}