package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimSearchRequest;
import com.ebao.li.mobs.agency.dto.ClaimSearchResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimSearching extends ApplicationEvent {

  /**
   *
   */
  private static final long serialVersionUID = 4015292667656976592L;

  public ClaimSearching(ClaimCaseEventObject<ClaimSearchRequest, ClaimSearchResponse> source) {
    super(source);
  }

}
