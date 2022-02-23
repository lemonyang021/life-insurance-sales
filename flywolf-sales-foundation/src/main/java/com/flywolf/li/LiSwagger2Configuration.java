package com.flywolf.li;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

public interface LiSwagger2Configuration {


    String getTitle();

    String getTermsOfServiceUrl();

    Contact getContact();

    String getVersion();

    ApiInfo getApiInfo();
}
