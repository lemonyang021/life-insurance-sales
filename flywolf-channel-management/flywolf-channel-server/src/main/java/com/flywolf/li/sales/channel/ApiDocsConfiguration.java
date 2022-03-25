package com.flywolf.li.sales.channel;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;


@Configuration
public class ApiDocsConfiguration {

    @Bean
    public GroupedOpenApi channelDocket() {
        return GroupedOpenApi.builder()
                .group("channel")
                .pathsToMatch("/channel/**")
                .addOperationCustomizer(customGlobalHeaders())
                .build();
    }

    @Bean
    public GroupedOpenApi douDocket() {
        return GroupedOpenApi.builder()
                .group("dou")
                .pathsToMatch("/dou/**")
                .addOperationCustomizer(customGlobalHeaders())
                .build();
    }

    /**
     * 给所有@Operation注释的接口添加一个tellerno请求头参数
     * @return
     */
    @Bean
    public OperationCustomizer customGlobalHeaders() {

        return (Operation operation, HandlerMethod handlerMethod) -> {

            Parameter authorization = new Parameter().in(ParameterIn.HEADER.toString()).name("Authorization")
                    .description("Authorization details JWT token").example("xxx_token")
                    .schema(new StringSchema()).required(true);

            Parameter applicationId = new Parameter().in(ParameterIn.HEADER.toString()).schema(new StringSchema())
                    .name("Application-Id").description("Originating application or client using the service").example("P05")
                    .required(true);

            operation.addParametersItem(authorization);
            operation.addParametersItem(applicationId);

            return operation;
        };
    }
}
