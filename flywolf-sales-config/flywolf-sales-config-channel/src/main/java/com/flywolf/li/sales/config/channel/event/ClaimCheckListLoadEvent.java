package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCheckListResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCheckListLoadEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316123L;

  public ClaimCheckListLoadEvent(ClaimCaseEventObject<String, ClaimCheckListResponse> source) {
    super(source);
  }

}
