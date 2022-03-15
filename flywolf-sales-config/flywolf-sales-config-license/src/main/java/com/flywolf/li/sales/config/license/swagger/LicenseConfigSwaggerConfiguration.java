package com.flywolf.li.sales.config.license.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LicenseConfigSwaggerConfiguration  {

    @Bean
    public GroupedOpenApi licenseDocket() {

        return GroupedOpenApi.builder()
                .group("license")
                .pathsToMatch("/license/**")
                .build();
    }
}
