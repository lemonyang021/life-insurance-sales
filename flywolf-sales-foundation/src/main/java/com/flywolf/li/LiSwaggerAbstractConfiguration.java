package com.flywolf.li;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.CollectionUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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

    private List<ResponseMessage> responseMessageList;

    //设置全局响应状态码
    @Cacheable("ClaimSwaggerResponseHttpCode")
    public void LiSwaggerAbstractConfiguration() {
        if (CollectionUtils.isEmpty(responseMessageList)) {
            responseMessageList = new ArrayList<ResponseMessage>();
            for (Map.Entry<Integer, String> m : responseCode.entrySet()) {
                responseMessageList.add(new ResponseMessageBuilder().code(m.getKey()).message(m.getValue()).build());
            }
        }
    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title(this.getTitle())
                .termsOfServiceUrl(this.getTermsOfServiceUrl()).contact(this.getContact())
                .version(this.getVersion()).build();
    }

}
