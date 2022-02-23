package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCheckListRequest;
import com.ebao.li.mobs.agency.dto.ClaimCheckListResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCheckListSaveEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCheckListSaveEvent(ClaimCaseEventObject<ClaimCheckListRequest, ClaimCheckListResponse> source) {
    super(source);
  }

}
