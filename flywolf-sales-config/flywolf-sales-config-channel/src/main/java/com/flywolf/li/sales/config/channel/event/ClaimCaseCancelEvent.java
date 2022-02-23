package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCaseCancelRequest;
import com.ebao.li.mobs.agency.dto.ClaimCaseCancelResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCaseCancelEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCaseCancelEvent(ClaimCaseEventObject<ClaimCaseCancelRequest, ClaimCaseCancelResponse> source) {
    super(source);
  }


}
