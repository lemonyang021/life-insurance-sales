package com.flywolf.li.sales.dou.repository;

import com.flywolf.li.sales.dou.entity.Dou;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DouRepository extends JpaRepository<Dou, Long> , JpaSpecificationExecutor<Dou> {
    Dou findByName(String name);
    Dou findByCode(String code);
}