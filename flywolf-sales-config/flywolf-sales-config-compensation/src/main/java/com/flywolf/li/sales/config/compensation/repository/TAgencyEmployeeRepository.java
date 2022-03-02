package com.flywolf.li.sales.config.compensation.repository;

import com.flywolf.li.sales.config.compensation.data.TAgencyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgencyEmployeeRepository extends JpaRepository<TAgencyEmployee, String>, JpaSpecificationExecutor<TAgencyEmployee> {

}