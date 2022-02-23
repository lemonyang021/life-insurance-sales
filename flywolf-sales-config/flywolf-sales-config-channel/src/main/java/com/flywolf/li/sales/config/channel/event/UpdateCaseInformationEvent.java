package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimCaseCommonResponse;
import com.ebao.li.mobs.agency.dto.UpdateCaseRequest;
import org.springframework.context.ApplicationEvent;

public class UpdateCaseInformationEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public UpdateCaseInformationEvent(ClaimCaseEventObject<UpdateCaseRequest, ClaimCaseCommonResponse> source) {
    super(source);
  }


}
