package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.InsuredQueryRequest;
import com.ebao.li.mobs.agency.dto.InsuredQueryResponse;
import org.springframework.context.ApplicationEvent;

public class InsuredQueryEvent extends ApplicationEvent {
  private static final long serialVersionUID = -3546507816971120336L;

  public InsuredQueryEvent(ClaimCaseEventObject<InsuredQueryRequest, InsuredQueryResponse> source) {
    super(source);
  }

}
