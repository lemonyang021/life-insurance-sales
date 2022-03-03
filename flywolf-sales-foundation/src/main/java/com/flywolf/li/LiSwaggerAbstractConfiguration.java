package com.flywolf.li;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;

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

    //设置全局响应状态码
    @Cacheable("LiSwaggerResponseHttpCode")
    public List<ResponseMessage> getResponseMessage() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        for (Map.Entry<Integer, String> m : responseCode.entrySet()) {
            responseMessageList.add(new ResponseMessageBuilder().code(m.getKey()).message(m.getValue()).build());
        }
        return responseMessageList;
    }

    //设置全局请求参数
    @Cacheable("GlobalOperationParameters")
    public List<Parameter> getGlobalOperationParameters() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        // header query cookie
        parameterBuilder.name("X-Auth-Token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(parameterBuilder.build());
        parameterBuilder.name("X-userid").description("用户id").modelRef(new ModelRef("int")).parameterType("query").required(false);
        pars.add(parameterBuilder.build());
        parameterBuilder.name("X-name").description("用户名").modelRef(new ModelRef("string")).parameterType("cookie").required(false);
        pars.add(parameterBuilder.build());
        return pars;
    }

    @Cacheable("ApiInfo")
    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title(this.getTitle())
                .termsOfServiceUrl(this.getTermsOfServiceUrl()).contact(this.getContact())
                .version(this.getVersion()).build();
    }

}
