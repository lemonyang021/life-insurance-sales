package com.flywolf.li.sales.online.generic.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
public class SimpleClientServiceRequest implements LiRequest {

    private static final long serialVersionUID = 4351034925864105751L;

    private String clientRequestId = UUID.randomUUID().toString();
    private Date clientRequestTime = new Date();
    private Date serviceReqTime = new Date();
    private String serializedExtensionObj;
    private Map<String, String> extendedProps;
}
