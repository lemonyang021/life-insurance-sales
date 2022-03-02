package com.flywolf.li.sales.config.channel.swagger;

import com.flywolf.li.LiSwaggerAbstractConfiguration;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ChannelConfigSwaggerConfiguration extends LiSwaggerAbstractConfiguration {

    public Docket claimRestApi(Tag newTag, String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(super.getApiInfo()).globalResponseMessage(RequestMethod.GET, super.getResponseMessageList())
                .globalResponseMessage(RequestMethod.POST, super.getResponseMessageList())
                .protocols(Sets.newHashSet(super.getScheme())).groupName("sales").tags(new Tag("channel", "")).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.regex("/channel.*")).build();
    }
}
