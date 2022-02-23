package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.CandidateUsersQueryRequest;
import com.ebao.li.mobs.agency.dto.ClaimCandidateUsersResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimCandidateUsersGetting extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;

  public ClaimCandidateUsersGetting(ClaimCaseEventObject<CandidateUsersQueryRequest, ClaimCandidateUsersResponse> source) {
    super(source);
  }


}
