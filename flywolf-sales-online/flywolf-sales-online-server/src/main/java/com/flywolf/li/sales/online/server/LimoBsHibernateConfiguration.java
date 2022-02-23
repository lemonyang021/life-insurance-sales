package com.flywolf.li.sales.online.server;

import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.flywolf.li.framework.context.DBContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@ConditionalOnProperty(value = "limobs.multi.datasource.enabeld", havingValue = "true",
//    matchIfMissing = false)
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryLimoBs",
    transactionManagerRef = "transactionManagerLimoBs", basePackages = "com.ebao.li.mobs")
public class LimoBsHibernateConfiguration {
  @Autowired
  private JpaProperties jpaProperties;
  @Autowired
  private HibernateProperties hibernateProperties;

  @Primary
  @Bean(name = {"limobsDataSource","dataSource"})
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource limobsDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean({"entityManagerLimoBs","entityManager"})
  public EntityManager entityManagerLimoBs(EntityManagerFactoryBuilder builder) {
    return Objects.requireNonNull(entityManagerFactoryBean(builder).getObject())
        .createEntityManager();
  }

  @Primary
  @Bean({"entityManagerFactoryLimoBs","entityManagerFactory"})
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
      EntityManagerFactoryBuilder builder) {
    return builder.dataSource(limobsDataSource()).properties(getVendorProperties())
        .packages("com.ebao.li.mobs").persistenceUnit("limobsPersistenceUnit").build();

  }

  private Map<String, Object> getVendorProperties() {
    return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
        new HibernateSettings());
  }

  @Primary
  @Bean({"transactionManagerLimoBs","transactionManager"})
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(
        Objects.requireNonNull(entityManagerFactoryBean(builder).getObject()));
  }

  @Bean(name =  DBContext.TRANS_JT)
  public JdbcTemplate secondaryJdbcTemplate(@Qualifier(DBContext.TRANS_DS) DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean(name = DBContext.TRANS_NP_JT)
  public NamedParameterJdbcTemplate secondaryNamedParamJdbcTemplate(@Qualifier(DBContext.TRANS_DS) DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }
  
}
