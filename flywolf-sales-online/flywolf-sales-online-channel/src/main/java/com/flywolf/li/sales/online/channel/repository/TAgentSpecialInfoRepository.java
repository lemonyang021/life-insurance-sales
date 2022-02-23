package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentSpecialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentSpecialInfoRepository extends JpaRepository<TAgentSpecialInfo, String>, JpaSpecificationExecutor<TAgentSpecialInfo> {

}