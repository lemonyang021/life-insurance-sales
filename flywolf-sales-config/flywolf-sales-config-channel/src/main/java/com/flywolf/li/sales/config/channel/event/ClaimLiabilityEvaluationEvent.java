package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationRequest;
import com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimLiabilityEvaluationEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimLiabilityEvaluationEvent(ClaimCaseEventObject<ClaimLiabilityEvaluationRequest, ClaimLiabilityEvaluationResponse> source) {
    super(source);
  }


}
