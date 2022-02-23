package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimAcceptRequest;
import com.ebao.li.mobs.agency.dto.ClaimAcceptResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimPolicyAcceptEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimPolicyAcceptEvent(ClaimCaseEventObject<ClaimAcceptRequest, ClaimAcceptResponse> source) {
    super(source);
  }

}
