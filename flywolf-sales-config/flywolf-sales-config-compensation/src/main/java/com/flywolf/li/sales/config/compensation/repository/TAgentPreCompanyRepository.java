package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentPreCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentPreCompanyRepository extends JpaRepository<TAgentPreCompany, String>, JpaSpecificationExecutor<TAgentPreCompany> {

}