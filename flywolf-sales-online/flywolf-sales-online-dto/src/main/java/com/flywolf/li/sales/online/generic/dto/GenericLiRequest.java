package com.flywolf.li.sales.online.generic.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
public class GenericLiRequest implements LiRequest {
    private static final long serialVersionUID = 1L;

    private String clientRequestId;
    private Date clientRequestTime;
    private Date serviceReqTime;
    private String serializedExtensionObj;
    private Map<String, String> extendedProps;


    public GenericLiRequest(boolean autoFill) {
        if (autoFill) {
            clientRequestId = UUID.randomUUID().toString();
            clientRequestTime = new Date();
            serviceReqTime = new Date();
        }
    }
}
