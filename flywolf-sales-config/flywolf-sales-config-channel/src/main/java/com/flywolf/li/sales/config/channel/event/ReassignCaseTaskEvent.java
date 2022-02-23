package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ReassignCaseTaskRequest;
import com.ebao.li.mobs.agency.dto.ReassignCaseTaskResponse;
import org.springframework.context.ApplicationEvent;

public class ReassignCaseTaskEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ReassignCaseTaskEvent(ClaimCaseEventObject<ReassignCaseTaskRequest, ReassignCaseTaskResponse> source) {
    super(source);
  }


}
