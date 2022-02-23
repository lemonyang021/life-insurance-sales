package com.flywolf.li.sales.config.channel.repository;


import com.flywolf.li.sales.config.channel.data.TAgentCate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TAgentCateRepository extends JpaRepository<TAgentCate, String>, JpaSpecificationExecutor<TAgentCate> {

}