package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCaseResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCaseDetailGettingEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCaseDetailGettingEvent(ClaimCaseEventObject<String, ClaimCaseResponse> source) {
    super(source);
  }


}
