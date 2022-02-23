package com.flywolf.li.sales.online.server;

import com.flywolf.li.framework.tenant.TenantFilterConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
value = TenantFilterConfiguration.class)})
@SpringBootApplication(exclude = CacheMetricsAutoConfiguration.class)
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@EnableCaching
@EnableSwagger2
public class MoAgencybsCoreApplication extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(MoAgencybsCoreApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(MoAgencybsCoreApplication.class, args);
  }
}
