package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.UploadCaseDocumentsRequest;
import com.ebao.li.mobs.agency.dto.UploadCaseDocumentsResponse;
import org.springframework.context.ApplicationEvent;

public class ClaimDocumentsUploadEvent extends ApplicationEvent {

  /**
   *
   */
  private static final long serialVersionUID = -1752058767271963051L;

  public ClaimDocumentsUploadEvent(ClaimCaseEventObject<UploadCaseDocumentsRequest, UploadCaseDocumentsResponse> source) {
    super(source);
  }


}
