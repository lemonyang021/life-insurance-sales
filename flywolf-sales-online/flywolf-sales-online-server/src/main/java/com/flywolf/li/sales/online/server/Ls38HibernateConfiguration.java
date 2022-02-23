package com.flywolf.li.sales.online.server;

import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ConditionalOnProperty(value = "limobs.multi.datasource.enabeld", havingValue = "true",
    matchIfMissing = false)
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryLs38",
    transactionManagerRef = "transactionManagerLs38", basePackages = {"com.ebao.li.mobs.ls38"})
public class Ls38HibernateConfiguration {
  @Autowired
  private JpaProperties jpaProperties;
  @Autowired
  private HibernateProperties hibernateProperties;

  @Bean(name = "ls38DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.ls38")
  public DataSource ls38DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean("entityManagerLs38")
  public EntityManager entityManagerLs38(EntityManagerFactoryBuilder builder) {
    return Objects.requireNonNull(entityManagerFactoryLs38(builder).getObject())
        .createEntityManager();
  }

  @Bean("entityManagerFactoryLs38")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryLs38(
      EntityManagerFactoryBuilder builder) {
    return builder.dataSource(ls38DataSource()).properties(getVendorProperties())
        .packages("com.ebao.li.mobs.ls38").persistenceUnit("ls38PersistenceUnit").build();

  }

  private Map<String, Object> getVendorProperties() {
    return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
        new HibernateSettings());
  }

  @Bean("transactionManagerLs38")
  public PlatformTransactionManager transactionManagerLs38(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(
        Objects.requireNonNull(entityManagerFactoryLs38(builder).getObject()));
  }
}
