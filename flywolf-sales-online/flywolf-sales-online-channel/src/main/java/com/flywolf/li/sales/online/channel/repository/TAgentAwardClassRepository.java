package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentAwardClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentAwardClassRepository extends JpaRepository<TAgentAwardClass, String>, JpaSpecificationExecutor<TAgentAwardClass> {

}