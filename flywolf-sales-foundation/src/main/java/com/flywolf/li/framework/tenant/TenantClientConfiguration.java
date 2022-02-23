package com.flywolf.li.framework.tenant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;

// import feign.Feign;

@Configuration
public class TenantClientConfiguration {

  // @Bean
  // @Scope("prototype")
  // public Feign.Builder feignBuilder() {
  // return Feign.builder();
  // }

  @Bean
  public TenantClient tenantClient() {
    return new TenantClientFallback();
  }
}
