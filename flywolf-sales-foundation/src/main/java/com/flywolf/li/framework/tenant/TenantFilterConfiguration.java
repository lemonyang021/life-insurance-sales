package com.flywolf.li.framework.tenant;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;


@Configuration
public class TenantFilterConfiguration {

  @Bean(name = "liTenantFilter")
  public Filter logContextFilter() {
    return new TenantFilterLimo();
  }

  @Bean
  public FilterRegistrationBean<Filter> logTenantContextFilterRegistration() {
    FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(logContextFilter());
    registrationBean.setName("liTenantFilter");
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
    registrationBean.addUrlPatterns("/*");
    registrationBean.addInitParameter("encoding", "UTF-8");
    return registrationBean;
  }

}
