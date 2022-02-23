package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentGradeHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentGradeHisRepository extends JpaRepository<TAgentGradeHis, String>, JpaSpecificationExecutor<TAgentGradeHis> {

}