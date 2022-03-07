package com.flywolf.li.sales.config.license.swagger;

import com.flywolf.li.LiSwaggerAbstractConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class LicenseConfigSwaggerConfiguration extends LiSwaggerAbstractConfiguration {

    @Bean
    public Docket licenseDocket() {
        String basePackage = "com.flywolf.li.sales.config.license.controller";
        Tag tag = new Tag("license", "");
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(super.getApiInfo())
                .globalRequestParameters(super.getGlobalRequestParameters())
                .globalResponses(HttpMethod.GET, super.getGlobalResonseMessage())
                .globalResponses(HttpMethod.POST, super.getGlobalResonseMessage())
                .groupName("license").tags(tag).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.regex("/license.*")).build();
    }
}
