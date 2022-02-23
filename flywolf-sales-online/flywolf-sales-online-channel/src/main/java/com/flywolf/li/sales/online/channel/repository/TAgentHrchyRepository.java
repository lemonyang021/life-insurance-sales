package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentHrchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentHrchyRepository extends JpaRepository<TAgentHrchy, String>, JpaSpecificationExecutor<TAgentHrchy> {

}