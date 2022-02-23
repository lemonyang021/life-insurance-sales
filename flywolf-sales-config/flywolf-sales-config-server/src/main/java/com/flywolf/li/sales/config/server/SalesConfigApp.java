package com.flywolf.li.sales.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = CacheMetricsAutoConfiguration.class)
@EnableDiscoveryClient
@EnableHystrix//开启熔断降级机制
@EnableFeignClients
@EnableCaching//开启缓存机制
@EnableSwagger2//开始swagger
public class SalesConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(SalesConfigApp.class, args);
    }
}
