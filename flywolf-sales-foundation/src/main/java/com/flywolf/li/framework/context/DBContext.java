package com.flywolf.li.framework.context;

public interface DBContext {
  
//  String CFG_DS = "cfgDataSource";
//  String CFG_DEFAULT = "dataSource";
//  String CFG_JT = "cfgJdbcTemplate";
//  String CFG_NP_JT = "cfgNamedParamJdbcTemplate";
//  
//  String CFG_EM ="cfgEntityManager";
//  String CFG_TM ="cfgTransactionManager";
//  String CFG_EMF="cfgEntityManagerFactory";
  
  String TRANS_DS = "dataSource";
  String TRANS_JT = "jdbcTemplate";
  String TRANS_NP_JT = "namedParamJdbcTemplate";
  
  String TRANS_EM ="entityManager";
  String TRANS_TM ="transactionManager";
  String TRANS_EMF="entityManagerFactory";
  
  
}
