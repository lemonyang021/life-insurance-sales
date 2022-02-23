package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentForbidProductC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentForbidProductCRepository extends JpaRepository<TAgentForbidProductC, Void>, JpaSpecificationExecutor<TAgentForbidProductC> {

}