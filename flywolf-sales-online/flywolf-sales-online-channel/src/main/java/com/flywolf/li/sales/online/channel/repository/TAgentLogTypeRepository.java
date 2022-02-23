package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLogTypeRepository extends JpaRepository<TAgentLogType, String>, JpaSpecificationExecutor<TAgentLogType> {

}