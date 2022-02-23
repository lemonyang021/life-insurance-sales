package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentGradeEntitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentGradeEntitleRepository extends JpaRepository<TAgentGradeEntitle, String>, JpaSpecificationExecutor<TAgentGradeEntitle> {

}