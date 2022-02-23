package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentWelfareClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentWelfareClassRepository extends JpaRepository<TAgentWelfareClass, String>, JpaSpecificationExecutor<TAgentWelfareClass> {

}