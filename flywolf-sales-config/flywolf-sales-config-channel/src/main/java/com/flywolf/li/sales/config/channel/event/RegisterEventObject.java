package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.mobs.agency.dto.ClaimContext;
import com.ebao.li.mobs.agency.dto.RegisterRequest;
import com.ebao.li.mobs.agency.dto.RegisterResponse;

public class RegisterEventObject extends ClaimEventObject {

  public RegisterEventObject(ClaimContext<RegisterRequest, RegisterResponse> context) {
    super(context);
    this.request = context.getRequest();
  }
  /**
   *
   */
  private static final long serialVersionUID = -4140791029719501018L;
  private RegisterRequest request;
  private String claimCaseNo;
  private String claimCaseStatus;

  public RegisterRequest getRequest() {
    return request;
  }
  public void setRequest(RegisterRequest request) {
    this.request = request;
  }
  public String getClaimCaseNo() {
    return claimCaseNo;
  }
  public void setClaimCaseNo(String claimCaseNo) {
    this.claimCaseNo = claimCaseNo;
  }
  public String getClaimCaseStatus() {
    return claimCaseStatus;
  }
  public void setClaimCaseStatus(String claimCaseStatus) {
    this.claimCaseStatus = claimCaseStatus;
  }


}
