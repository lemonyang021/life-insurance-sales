package com.flywolf.li.sales.online.context;

import com.flywolf.li.sales.online.generic.dto.GenericLiRequest;
import com.flywolf.li.sales.online.generic.dto.GenericLiResponse;
import lombok.Data;

@Data
public class SalesOnlineContext<Rq extends GenericLiRequest, Rs extends GenericLiResponse> extends GenericSalesOnlineContext {

    private static final long serialVersionUID = -430018312175657980L;

    private Rq request;

    private Rs response;
}
