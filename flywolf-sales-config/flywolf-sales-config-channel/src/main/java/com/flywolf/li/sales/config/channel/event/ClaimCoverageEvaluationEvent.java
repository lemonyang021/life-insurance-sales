package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationRequest;
import com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCoverageEvaluationEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCoverageEvaluationEvent(ClaimCaseEventObject<ClaimCoverageEvaluationRequest, ClaimCoverageEvaluationResponse> source) {
    super(source);
  }


}
