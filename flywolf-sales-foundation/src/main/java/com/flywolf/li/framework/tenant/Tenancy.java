package com.flywolf.li.framework.tenant;

import java.io.Serializable;
import java.util.Date;

public class Tenancy implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -8650734730162882512L;

  public Tenancy() {

  }

  public Tenancy(String xtenantId, String contractorCode, String brokerCode, String channelCode,
      String callerCode, Long tenantUserId, Long insurerId) {
    this.xtenantId = xtenantId;
    this.contractorCode = contractorCode;
    this.brokerCode = brokerCode;
    this.channelCode = channelCode;
    this.callerCode = callerCode;
    this.tenantUserId = tenantUserId;
    this.insurerId = insurerId;
  }

  public Tenancy(String xtenantId, String contractorCode, String brokerCode, String channelCode,
      String callerCode, Long tenantUserId) {
    this.xtenantId = xtenantId;
    this.contractorCode = contractorCode;
    this.brokerCode = brokerCode;
    this.channelCode = channelCode;
    this.callerCode = callerCode;
    this.tenantUserId = tenantUserId;
  }

  private String xtenantId;
  private String contractorCode;
  private String brokerCode;
  private String channelCode;
  private String callerCode;
  private Long tenantUserId;
  private String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
  private String defaultTimeZone = "GMT+8";
  private Long insurerId;
  private Date currentUserLocalTime;
  private Long tenantOrgId;
  
  public String getXtenantId() {
    return xtenantId;
  }

  public Long getInsurerId() {
    return insurerId;
  }

  public void setInsurerId(Long insurerId) {
    this.insurerId = insurerId;
  }

  public void setXtenantId(String xtenantId) {
    this.xtenantId = xtenantId;
  }

  public String getContractorCode() {
    return contractorCode;
  }

  public void setContractorCode(String contractorCode) {
    this.contractorCode = contractorCode;
  }

  public String getBrokerCode() {
    return brokerCode;
  }

  public void setBrokerCode(String brokerCode) {
    this.brokerCode = brokerCode;
  }

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public String getCallerCode() {
    return callerCode;
  }

  public void setCallerCode(String callerCode) {
    this.callerCode = callerCode;
  }

  public Long getTenantUserId() {
    return tenantUserId;
  }

  public void setTenantUserId(Long tenantUserId) {
    this.tenantUserId = tenantUserId;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public String getDefaultTimeZone() {
    return defaultTimeZone;
  }

  public void setDefaultTimeZone(String defaultTimeZone) {
    this.defaultTimeZone = defaultTimeZone;
  }

  public Date getCurrentUserLocalTime() {
    return currentUserLocalTime;
  }

  public void setCurrentUserLocalTime(Date currentUserLocalTime) {
    this.currentUserLocalTime = currentUserLocalTime;
  }

  public Long getTenantOrgId() {
    return tenantOrgId;
  }

  public void setTenantOrgId(Long tenantOrgId) {
    this.tenantOrgId = tenantOrgId;
  }

}
