package com.flywolf.li.sales.online.compensation.swagger;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class CompensationSwagger {

  @Value("${springfox.documentation.swagger.v2.scheme:http}")
  private String scheme;

  @Bean
  public Docket claimRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        .protocols(Sets.newHashSet(scheme)).groupName("claim").tags(new Tag("Claim", "")).select()
        .apis(RequestHandlerSelectors.basePackage("com.ebao.li.mobs.claim.web"))
        .paths(PathSelectors.regex("/claim.*")).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("APIs of Claim")
        .termsOfServiceUrl("http://docs.ebaocloud.life/").contact(new Contact("eBaoTech", "", ""))
        .version("1.0").build();
  }
  
  @Bean
  public Docket policyRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiPolicyInfo())
        .protocols(Sets.newHashSet(scheme)).groupName("policy").tags(new Tag("Claim", "")).select()
        .apis(RequestHandlerSelectors.basePackage("com.ebao.li.mobs.claimpolicy"))
        .paths(PathSelectors.regex("/claim.*")).build();
  }

  private ApiInfo apiPolicyInfo() {
    return new ApiInfoBuilder().title("APIs of Claim Policy")
        .termsOfServiceUrl("http://docs.ebaocloud.life/").contact(new Contact("eBaoTech", "", ""))
        .version("1.0").build();
  }

  @Bean
  public Docket caseRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(caseApiInfo())
        .protocols(Sets.newHashSet(scheme)).groupName("case").tags(new Tag("Case Management", ""))
        .select().apis(RequestHandlerSelectors.basePackage("com.ebao.li.mobs.claim"))
        .paths(PathSelectors.regex("/case.*")).build();
  }

  private ApiInfo caseApiInfo() {
    return new ApiInfoBuilder().title("APIs of Case Management")
        .termsOfServiceUrl("http://docs.ebaocloud.life/").contact(new Contact("eBaoTech", "", ""))
        .version("1.0").build();
  }
}
