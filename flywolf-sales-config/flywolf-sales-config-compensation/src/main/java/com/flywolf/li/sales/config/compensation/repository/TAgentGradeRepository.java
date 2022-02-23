package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentGradeRepository extends JpaRepository<TAgentGrade, String>, JpaSpecificationExecutor<TAgentGrade> {

}