package com.flywolf.li.sales.config.license.swagger;

import com.flywolf.li.LiSwaggerAbstractConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LicenseConfigSwaggerConfiguration extends LiSwaggerAbstractConfiguration {

    @Bean
    public GroupedOpenApi licenseDocket() {

        return GroupedOpenApi.builder()
                .group("license")
                .pathsToMatch("/license/**")
                .build();
    }
}
