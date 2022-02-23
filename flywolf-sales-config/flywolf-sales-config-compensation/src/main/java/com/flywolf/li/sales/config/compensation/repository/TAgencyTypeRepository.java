package com.flywolf.li.sales.config.compensation.repository;


import com.flywolf.li.sales.config.compensation.data.TAgencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgencyTypeRepository extends JpaRepository<TAgencyType, String>, JpaSpecificationExecutor<TAgencyType> {

}