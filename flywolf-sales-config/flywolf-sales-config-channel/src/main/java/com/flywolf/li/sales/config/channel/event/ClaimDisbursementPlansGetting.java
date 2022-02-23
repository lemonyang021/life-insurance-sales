package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.DisbursementPlanInfo;
import org.springframework.context.ApplicationEvent;

public class ClaimDisbursementPlansGetting extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimDisbursementPlansGetting(ClaimCaseEventObject<String, DisbursementPlanInfo> source) {
    super(source);
  }


}
