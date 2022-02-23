package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.DisbursementPlanRequest;
import com.ebao.li.mobs.agency.dto.DisbursementPlanResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimDisbursementPlanEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimDisbursementPlanEvent(ClaimCaseEventObject<DisbursementPlanRequest, DisbursementPlanResponse> source) {
    super(source);
  }


}
