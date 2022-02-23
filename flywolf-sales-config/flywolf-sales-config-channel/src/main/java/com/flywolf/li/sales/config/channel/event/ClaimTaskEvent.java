package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimTaskQueryRequest;
import com.ebao.li.mobs.agency.dto.ClaimTaskQueryResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimTaskEvent extends ApplicationEvent {

  private static final long serialVersionUID = -3229279741894680964L;

  public ClaimTaskEvent(
      ClaimCaseEventObject<ClaimTaskQueryRequest, ClaimTaskQueryResponse> source) {
    super(source);
  }
}
