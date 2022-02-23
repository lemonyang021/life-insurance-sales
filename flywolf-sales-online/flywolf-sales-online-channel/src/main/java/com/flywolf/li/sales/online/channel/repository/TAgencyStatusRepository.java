package com.flywolf.li.sales.online.channel.repository;

import com.ebao.li.mobs.agency.jpa.data.TAgencyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgencyStatusRepository extends JpaRepository<TAgencyStatus, String>, JpaSpecificationExecutor<TAgencyStatus> {

}