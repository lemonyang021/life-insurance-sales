package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentLetterPrint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentLetterPrintRepository extends JpaRepository<TAgentLetterPrint, String>, JpaSpecificationExecutor<TAgentLetterPrint> {

}