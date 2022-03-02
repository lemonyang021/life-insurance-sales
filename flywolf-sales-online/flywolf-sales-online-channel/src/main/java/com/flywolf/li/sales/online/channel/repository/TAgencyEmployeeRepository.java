package com.flywolf.li.sales.online.channel.repository;

import com.flywolf.li.sales.online.channel.data.TAgencyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgencyEmployeeRepository extends JpaRepository<TAgencyEmployee, String>, JpaSpecificationExecutor<TAgencyEmployee> {

}