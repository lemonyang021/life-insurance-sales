package com.flywolf.li.sales.config.channel.event;

import com.ebao.li.flywolf.sales.dto.generic.LiResult;
import com.ebao.li.mobs.agency.dto.GenericClaimContext;
import com.ebao.li.flywolf.sales.dto.generic.ClientServiceResponse;

import java.io.Serializable;

public class ClaimEventObject implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -4140791029719501018L;
  private String tenantCode;
  private String insurerCode;
  private Boolean isMocked;
  private LiResult result = new LiResult();

  public String getTenantCode() {
    return tenantCode;
  }

  public void setTenantCode(String tenantCode) {
    this.tenantCode = tenantCode;
  }

  public LiResult getResult() {
    return result;
  }

  public void setResult(LiResult result) {
    this.result = result;
  }

  public String getInsurerCode() {
    return insurerCode;
  }

  public void setInsurerCode(String insurerCode) {
    this.insurerCode = insurerCode;
  }

  public ClaimEventObject(GenericClaimContext context){
    this.insurerCode= context.getInsurerCode();
    this.tenantCode = context.getHeader().getXtenantId();
    this.result.setResult(ClientServiceResponse.ServiceResultCode.FAILED);
  }

  public Boolean getIsMocked() {
    return isMocked;
  }

  public void setIsMocked(Boolean isMocked) {
    this.isMocked = isMocked;
  }

}
