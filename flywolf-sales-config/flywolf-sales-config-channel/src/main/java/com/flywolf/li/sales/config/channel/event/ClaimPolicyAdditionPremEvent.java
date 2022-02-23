package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimPolicyAdditionPremResponse;
import com.ebao.li.mobs.agency.dto.ClaimPolicyRequest;
import org.springframework.context.ApplicationEvent;

public class ClaimPolicyAdditionPremEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimPolicyAdditionPremEvent(ClaimCaseEventObject<ClaimPolicyRequest, ClaimPolicyAdditionPremResponse> source) {
    super(source);
  }

}
