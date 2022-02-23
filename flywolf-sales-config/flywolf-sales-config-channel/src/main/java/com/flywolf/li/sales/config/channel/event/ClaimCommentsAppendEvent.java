package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.AppendCaseCommentsRequest;
import com.ebao.li.mobs.agency.dto.AppendCaseCommentsResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCommentsAppendEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCommentsAppendEvent(ClaimCaseEventObject<AppendCaseCommentsRequest, AppendCaseCommentsResponse> source) {
    super(source);
  }


}
