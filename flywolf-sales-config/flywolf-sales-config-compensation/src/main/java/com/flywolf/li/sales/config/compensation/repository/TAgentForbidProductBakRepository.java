package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentForbidProductBak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentForbidProductBakRepository extends JpaRepository<TAgentForbidProductBak, String>, JpaSpecificationExecutor<TAgentForbidProductBak> {

}