package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimPolicyOsPremiumsRequest;
import com.ebao.li.mobs.agency.dto.PolicyRenewalExtractionResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimPolicyOsPremEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimPolicyOsPremEvent(ClaimCaseEventObject<ClaimPolicyOsPremiumsRequest, PolicyRenewalExtractionResponse> source) {
    super(source);
  }

}
