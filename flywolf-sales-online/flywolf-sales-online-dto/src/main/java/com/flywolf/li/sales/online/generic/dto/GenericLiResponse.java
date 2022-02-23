package com.flywolf.li.sales.online.generic.dto;

import lombok.Data;
import org.apache.commons.lang.ArrayUtils;

import java.util.Date;

@Data
public class GenericLiResponse implements LiResponse {

    /**
     *
     */
    private static final long serialVersionUID = 1744253276816314118L;

    private String serializedExtensionObj;
    private String clientRequestId;
    private Date ClientRequestTime;
    private ServiceResultCode result;
    private GenericValidationResult[] messages;
    private String[] exceptions;
    private Date serviceReqTime;
    private Date serviceResTime;
    private String traceId;


    public void addMessage(String code, String message) {
        if (getMessages() == null) {
            setMessages(new GenericValidationResult[]{});
        }
        GenericValidationResult result = new GenericValidationResult();
        result.setCode(code);
        result.setMessage(message);
        setMessages((GenericValidationResult[]) ArrayUtils.add(getMessages(), result));
    }

    public void addException(String exception) {
        if (getExceptions() == null) {
            setExceptions(new String[]{});
        }
        setExceptions((String[]) ArrayUtils.add(getExceptions(), exception));
    }

}
