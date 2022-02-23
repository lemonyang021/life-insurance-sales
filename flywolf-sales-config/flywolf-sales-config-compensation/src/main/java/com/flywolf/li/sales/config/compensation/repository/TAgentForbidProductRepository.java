package com.flywolf.li.sales.config.compensation.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgentForbidProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentForbidProductRepository extends JpaRepository<TAgentForbidProduct, String>, JpaSpecificationExecutor<TAgentForbidProduct> {

}