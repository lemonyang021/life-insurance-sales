package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.BankAccountUpdateRequest;
import com.ebao.li.mobs.agency.dto.BankAccountUpdateResponse;
import org.springframework.context.ApplicationEvent;

public class BankAccountUpdateEvent extends ApplicationEvent {

  /**
   *
   */
  private static final long serialVersionUID = 4015292667656976592L;

  public BankAccountUpdateEvent(ClaimCaseEventObject<BankAccountUpdateRequest, BankAccountUpdateResponse> source) {
    super(source);
  }

}
