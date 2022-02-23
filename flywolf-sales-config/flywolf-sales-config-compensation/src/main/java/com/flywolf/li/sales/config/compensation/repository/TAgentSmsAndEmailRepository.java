package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentSmsAndEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentSmsAndEmailRepository extends JpaRepository<TAgentSmsAndEmail, String>, JpaSpecificationExecutor<TAgentSmsAndEmail> {

}