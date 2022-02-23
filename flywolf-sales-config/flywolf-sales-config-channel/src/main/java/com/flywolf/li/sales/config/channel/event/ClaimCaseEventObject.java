package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.flywolf.sales.dto.generic.LiResult;

import java.io.Serializable;

public class ClaimCaseEventObject<REQ extends Serializable, RES extends Serializable>
    implements Serializable {

  private static final long serialVersionUID = 684644740301607778L;
  private String tenantCode;
  private String insurerCode;
  private Boolean isMocked;
  private LiResult result = new LiResult();
  private REQ request;
  private RES response;
  private String claimCaseNo;

  public REQ getRequest() {
    return request;
  }

  public void setRequest(REQ request) {
    this.request = request;
  }

  public RES getResponse() {
    return response;
  }

  public void setResponse(RES response) {
    this.response = response;
  }

  public String getTenantCode() {
    return tenantCode;
  }

  public void setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
  }

  public String getInsurerCode() {
    return insurerCode;
  }

  public void setInsurerCode(String insurerCode) {
    this.insurerCode = insurerCode;
  }

  public Boolean getIsMocked() {
    return isMocked;
  }

  public void setIsMocked(Boolean isMocked) {
    this.isMocked = isMocked;
  }

  public LiResult getResult() {
    return result;
  }

  public void setResult(LiResult result) {
    this.result = result;
  }

  public String getClaimCaseNo() {
    return claimCaseNo;
  }

  public void setClaimCaseNo(String claimCaseNo) {
    this.claimCaseNo = claimCaseNo;
  }
}
