package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.DisbursementAmountResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimDisbursementAmountsGetting extends ApplicationEvent {

  /**
   *
   */
  private static final long serialVersionUID = -5395530501915801774L;

  public ClaimDisbursementAmountsGetting(
      ClaimCaseEventObject<String, DisbursementAmountResponse> source) {
    super(source);
  }


}
