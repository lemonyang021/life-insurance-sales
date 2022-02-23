package com.flywolf.li.sales.online.helper;

import com.flywolf.li.framework.web.ServiceHeader;
import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import com.flywolf.li.sales.online.channel.dto.CreateChannelResponse;
import com.flywolf.li.sales.online.context.GenericSalesOnlineContext;
import com.flywolf.li.sales.online.context.SalesOnlineContext;
import com.flywolf.li.sales.online.generic.dto.ClientServiceResponse;
import com.flywolf.li.sales.online.generic.dto.GenericLiRequest;
import com.flywolf.li.sales.online.generic.dto.GenericLiResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SalesContextHelper {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SalesContextHelper.class);


    private static void setHeaderInfo(GenericSalesOnlineContext context, ServiceHeader header, String insurerCode) {
        context.setHeader(header);
        context.setInsurerCode(insurerCode);
    }

    private static void setGenericResponse(GenericLiResponse response, GenericLiRequest request) {
        response.setClientRequestId(request.getClientRequestId());
        response.setClientRequestTime(request.getClientRequestTime());
        response.setResult(ClientServiceResponse.ServiceResultCode.FAILED);
    }

    public static SalesOnlineContext<CreateChannelRequest, CreateChannelResponse> prepareContext(ServiceHeader header,
                                                                                                 String insurerCode,
                                                                                                 CreateChannelRequest req,
                                                                                                 CreateChannelResponse res) {

        SalesOnlineContext<CreateChannelRequest, CreateChannelResponse> context = new SalesOnlineContext<CreateChannelRequest, CreateChannelResponse>();
        setHeaderInfo(context, header, insurerCode);
        setGenericResponse(res, req);
        context.setRequest(req);
        context.setResponse(res);
        return context;
    }


}
