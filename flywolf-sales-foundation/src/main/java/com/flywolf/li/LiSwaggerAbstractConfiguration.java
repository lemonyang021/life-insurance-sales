package com.flywolf.li;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LiSwaggerAbstractConfiguration implements LiSwagger2Configuration {
    private String title = "APIs of Sales";
    private String termsOfServiceUrl = "https://docs.flywolf.com";
    private Contact contact = new Contact("flywolf", "", "");
    private String version = "1.0";

    @Value("${springfox.documentation.swagger.v2.scheme:http}")
    private String scheme;

    @Value("#{${springfox.documentation.swagger.v2.responsecode}}")
    private Map<Integer, String> responseCode;

    //生成通用响应信息
    @Cacheable("LiSwaggerResponseHttpCode")
    public List<Response> getGlobalResonseMessage() {
        List<Response> responseList = new ArrayList<>();
        for (Map.Entry<Integer, String> m : responseCode.entrySet()) {
            responseList.add(new ResponseBuilder().code(m.getKey().toString()).description(m.getValue()).build());
        }
        return responseList;
    }


    //生成全局通用参数
    @Cacheable("GlobalOperationParameters")
    public List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("X-Auth-Token")
                .description("token")
                .required(true)
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build());
        parameters.add(new RequestParameterBuilder()
                .name("X-userid")
                .description("用户id")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build());
        parameters.add(new RequestParameterBuilder()
                .name("X-name")
                .description("用户名")
                .required(true)
                .in(ParameterType.COOKIE)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build());
        return parameters;
    }

    //生成接口信息，包括标题、联系人等
    @Cacheable("ApiInfo")
    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title(this.getTitle())
                .termsOfServiceUrl(this.getTermsOfServiceUrl()).contact(this.getContact())
                .version(this.getVersion()).build();
    }

}
