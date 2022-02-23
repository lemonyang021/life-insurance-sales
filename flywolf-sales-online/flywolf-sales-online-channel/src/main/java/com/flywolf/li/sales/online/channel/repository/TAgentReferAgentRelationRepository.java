package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentReferAgentRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentReferAgentRelationRepository extends JpaRepository<TAgentReferAgentRelation, String>, JpaSpecificationExecutor<TAgentReferAgentRelation> {

}