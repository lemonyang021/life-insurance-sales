package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCaseApprovalRequest;
import com.ebao.li.mobs.agency.dto.ClaimCaseApprovalResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCaseApprovalResultEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCaseApprovalResultEvent(ClaimCaseEventObject<ClaimCaseApprovalRequest, ClaimCaseApprovalResponse> source) {
    super(source);
  }


}
