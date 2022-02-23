package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentPayMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentPayMethodRepository extends JpaRepository<TAgentPayMethod, String>, JpaSpecificationExecutor<TAgentPayMethod> {

}