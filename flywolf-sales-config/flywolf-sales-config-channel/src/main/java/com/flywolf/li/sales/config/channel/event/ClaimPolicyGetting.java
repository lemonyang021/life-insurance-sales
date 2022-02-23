package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimPolicyRequest;
import com.ebao.li.mobs.agency.dto.ClaimPolicyResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimPolicyGetting extends ApplicationEvent {


  /**
   *
   */
  private static final long serialVersionUID = 6108429907275326406L;

  public ClaimPolicyGetting(
      ClaimCaseEventObject<ClaimPolicyRequest, ClaimPolicyResponse> source) {
    super(source);
  }
}
