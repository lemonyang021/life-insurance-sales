package com.flywolf.li;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

@Data
public class LiSwaggerAbstractConfiguration {
    private String title = "APIs of Sales";
    private String termsOfServiceUrl = "https://docs.flywolf.com";
    //private Contact contact = new Contact("flywolf", "", "");
    private String version = "1.0";

    @Value("${springfox.documentation.swagger.v2.scheme:http}")
    private String scheme;

    @Value("#{${springfox.documentation.swagger.v2.responsecode}}")
    private Map<Integer, String> responseCode;
/*
    //生成通用响应信息
    @Cacheable("LiSwaggerResponseHttpCode")
    public List<Response> getGlobalResonseMessage() {
        List<Response> responseList = new ArrayList<>();
        for (Map.Entry<Integer, String> m : responseCode.entrySet()) {
            responseList.add(new ResponseBuilder().code(m.getKey().toString()).description(m.getValue()).build());
        }
        return responseList;
    }*/


    /*//生成全局通用参数
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
    }*/

    //生成接口信息，包括标题、联系人等
    @Cacheable("ApiInfo")
    public OpenAPI getApiInfo() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

}
