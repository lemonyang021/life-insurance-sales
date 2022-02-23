package com.flywolf.li.sales.online.server.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;


@Configuration
public class BsTenantFilterConfiguration {

  @Bean(name = "limobsTenantFilter")
  public Filter logContextFilter() {
    return new TenantFilter();
  }

  @Bean
  public FilterRegistrationBean<Filter> logTenantContextFilterRegistration() {
    FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(logContextFilter());
    registrationBean.setName("limobsTenantFilter");
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
    registrationBean.addUrlPatterns("/*");
    registrationBean.addInitParameter("encoding", "UTF-8");
    return registrationBean;
  }

}
