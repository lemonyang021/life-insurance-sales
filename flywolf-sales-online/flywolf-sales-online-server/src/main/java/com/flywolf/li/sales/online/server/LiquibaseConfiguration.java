package com.flywolf.li.sales.online.server;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@ConditionalOnClass(SpringLiquibase.class)
public class LiquibaseConfiguration {
  
  private SpringLiquibase liquibase(DataSource dataSource, LiquibaseProperties properties) {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog(properties.getChangeLog());
    liquibase.setContexts(properties.getContexts());
    liquibase.setDataSource(dataSource);
    liquibase.setDefaultSchema(properties.getDefaultSchema());
    liquibase.setDropFirst(properties.isDropFirst());
    liquibase.setShouldRun(properties.isEnabled());
    return liquibase;
  }

  @ConditionalOnProperty(value = "datasource.trans.liquibase.enabled", havingValue = "true",
      matchIfMissing = false)
  @Bean
  @ConfigurationProperties(prefix = "datasource.trans")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }
  @ConditionalOnProperty(value = "datasource.trans.liquibase.enabled", havingValue = "true",
      matchIfMissing = false)
  @Bean
  @ConfigurationProperties(prefix = "datasource.trans.liquibase")
  public LiquibaseProperties primaryLiquibaseProperties() {
    return new LiquibaseProperties();
  }
  @ConditionalOnProperty(value = "datasource.trans.liquibase.enabled", havingValue = "true",
      matchIfMissing = false)
  @Bean
  public SpringLiquibase primaryLiquibase() {
    return liquibase(primaryDataSource(), primaryLiquibaseProperties());
  }

}
