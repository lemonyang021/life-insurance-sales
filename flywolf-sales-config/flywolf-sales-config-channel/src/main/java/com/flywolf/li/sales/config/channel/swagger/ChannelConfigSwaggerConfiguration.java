package com.flywolf.li.sales.config.channel.swagger;

import com.flywolf.li.LiSwaggerAbstractConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ChannelConfigSwaggerConfiguration extends LiSwaggerAbstractConfiguration {

    @Bean
    public Docket channelDocket() {
        String basePackage = "com.flywolf.li.sales.config.channel.controller";
        Tag tag = new Tag("channel", "");
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(super.getApiInfo())
                .globalRequestParameters(super.getGlobalRequestParameters())
                .globalResponses(HttpMethod.GET, super.getGlobalResonseMessage())
                .globalResponses(HttpMethod.POST, super.getGlobalResonseMessage())
                .groupName("channel").tags(tag).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.regex("/channel.*")).build();
    }
}
