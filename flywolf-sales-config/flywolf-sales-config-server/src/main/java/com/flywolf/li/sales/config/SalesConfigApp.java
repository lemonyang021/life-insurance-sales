package com.flywolf.li.sales.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ComponentScan("com.flywolf.li")
@SpringBootApplication(exclude = CacheMetricsAutoConfiguration.class)
@EnableDiscoveryClient
@EnableHystrix//开启熔断降级机制
@EnableFeignClients
@EnableCaching//开启缓存机制
@Controller
public class SalesConfigApp {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesConfigApp.class, args);
    }
}
