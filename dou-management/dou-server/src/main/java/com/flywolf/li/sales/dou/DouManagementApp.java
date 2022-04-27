package com.flywolf.li.sales.dou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.flywolf.li")
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现机制
@EnableHystrix//开启熔断降级机制
@EnableFeignClients //开启远程服务调用
@EnableCaching//开启缓存机制
public class DouManagementApp {
    public static void main(String[] args) {
        SpringApplication.run(DouManagementApp.class, args);
    }
}
