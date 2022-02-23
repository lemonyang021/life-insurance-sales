package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.AcceptancePolicyResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCaseAcceptancePoliciesGettingEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCaseAcceptancePoliciesGettingEvent(
      ClaimCaseEventObject<String, AcceptancePolicyResponse> source) {
    super(source);
  }
}
