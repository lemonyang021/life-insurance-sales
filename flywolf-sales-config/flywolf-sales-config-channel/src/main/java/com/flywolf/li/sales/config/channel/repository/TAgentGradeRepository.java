package com.flywolf.li.sales.config.channel.repository;


import com.flywolf.li.sales.config.channel.data.TAgentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentGradeRepository extends JpaRepository<TAgentGrade, String>, JpaSpecificationExecutor<TAgentGrade> {

}