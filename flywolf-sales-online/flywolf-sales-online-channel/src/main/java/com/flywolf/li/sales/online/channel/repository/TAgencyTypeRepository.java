package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgencyTypeRepository extends JpaRepository<TAgencyType, String>, JpaSpecificationExecutor<TAgencyType> {

}