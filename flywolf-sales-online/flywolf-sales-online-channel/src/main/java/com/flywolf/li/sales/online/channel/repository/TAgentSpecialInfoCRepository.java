package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentSpecialInfoC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentSpecialInfoCRepository extends JpaRepository<TAgentSpecialInfoC, Void>, JpaSpecificationExecutor<TAgentSpecialInfoC> {

}