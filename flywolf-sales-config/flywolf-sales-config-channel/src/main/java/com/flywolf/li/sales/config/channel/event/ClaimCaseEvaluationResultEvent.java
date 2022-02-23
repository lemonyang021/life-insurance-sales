package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationRequest;
import com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCaseEvaluationResultEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCaseEvaluationResultEvent(ClaimCaseEventObject<ClaimCaseEvaluationRequest, ClaimCaseEvaluationResponse> source) {
    super(source);
  }


}
