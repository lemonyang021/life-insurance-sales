package com.flywolf.li.sales.config.channel.vo;

import com.ebao.li.flywolf.sales.dto.generic.GenericVO;

import java.util.Date;

/**
 * <p>
 * Title: eBaoTech GEL Claim
 * </p>
 * <p>
 * Description: RegistrationVO Business Object
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: eBaoTech Corporation
 * </p>
 * <p>
 * Create Time: 2004-8-27
 * </p>
 * 
 * @author Richard.Ning
 * @version 1.0
 */
public class RegistrationVO extends GenericVO {
  /**
   * 
   */
  private static final long serialVersionUID = 5373646233534902015L;

  private Long caseId;

  private String reportType;

  private Long insuredId;

  private Date accidentTime;

  private String caseNo;

  private String accierName;

  private Integer accierIdType;

  private String accierIdNumber;
  private String accierGender;

  private Long reporter;

  private Integer rptrRelation;

  private Long rptrAddr;

  private String rptrEmail;

  private String rptrMp;

  private String rptrTel;

  private String isRpterSms;

  private String rptrName;

  private String rptrZip;

  private Long agentId;
  private String agentCode;

  private String agentName;

  private String agentMp;

  private Long registrarId;

  private String isAgentSms;

  private Date registerTime;

  private Long recorderId;
  private Long updaterId;

  private Integer policyTypes[];

  private Integer policyType;

  private Integer caseStatus;

  private Integer claimType;

  private String address1;
  private String address2;
  private String address3;
  private String address4;
  private String address5;
  private String address6;
  private String address7;
  private String address8;
  private String accierGenderDesc = "";
  private String accierIdTypeDesc = "";

  private String isExist = "";

  private String generalComm;
  private Integer pendingStatus;
  private Date reviewDate;
  private Date notificationDate;
  private Long nextOfficerId;

  private Long operOrg;
  private Long operId;
  private String claimNature;
  private String caseLevel;

  // Add 2013-09-10 begin CQ:CRDB00855230
  private String eventLocation;
  private String eventDetails;
  // Add 2013-09-10 end CQ:CRDB00855230

  private Integer submitChannel;

  private Date applyDocDate;
  private Date deathDate;
  private Date branchNotificationDate;
  private Long receiveBranch;
  private Integer clmtType;
  private String clmtName;
  private Long clmtAddr;
  private Long claimant;
  private String clmtTel;
  private String claimantAddress;

  private Long orgId;

  private String directBillingIndi;
  //admission_date
  private Date admissionDate;

  //discharge date
  private Date dischargeDate;

  // death code
  private String deathCode;

  //incident code
  private  String incidentCode;

  //hospital id
  private String hospitalId;

  //diagnosis code
  private String diagnosisCode;

  //surgery id
  private  String surgeryId;

  //surgery date
  private Date surgeryDate;


  public String getDirectBillingIndi() {
    return directBillingIndi;
  }

  public void setDirectBillingIndi(String directBillingIndi) {
    this.directBillingIndi = directBillingIndi;
  }

  public Integer getSubmitChannel() {
    return submitChannel;
  }

  public void setSubmitChannel(Integer submitChannel) {
    this.submitChannel = submitChannel;
  }

  public String getClmtTel() {
    return clmtTel;
  }

  public void setClmtTel(String clmtTel) {
    this.clmtTel = clmtTel;
  }

  public Long getClaimant() {
    return claimant;
  }

  public void setClaimant(Long claimant) {
    this.claimant = claimant;
  }

  public String getClaimNature() {
    return claimNature;
  }

  public void setClaimNature(String claimNature) {
    this.claimNature = claimNature;
  }

  public String getCaseLevel() {
    return caseLevel;
  }

  public void setCaseLevel(String caseLevel) {
    this.caseLevel = caseLevel;
  }

  /**
   * @return Returns the notificationDate.
   */
  public Date getNotificationDate() {
    return notificationDate;
  }

  /**
   * @param notificationDate The notificationDate to set.
   */
  public void setNotificationDate(Date notificationDate) {
    this.notificationDate = notificationDate;
  }

  /**
   * @return Returns the reviewDate.
   */
  public Date getReviewDate() {
    return reviewDate;
  }

  /**
   * @param reviewDate The reviewDate to set.
   */
  public void setReviewDate(Date reviewDate) {
    this.reviewDate = reviewDate;
  }

  /**
   * @return Returns the reviewDate.
   */
  public Integer getPendingStatus() {
    return pendingStatus;
  }

  /**
   * @param pendingStatus The pendingStatus to set.
   */
  public void setPendingStatus(Integer pendingStatus) {
    this.pendingStatus = pendingStatus;
  }

  /**
   * @return Returns the generalComm.
   */
  public String getGeneralComm() {
    return generalComm;
  }

  /**
   * @param generalComm The generalComm to set.
   */
  public void setGeneralComm(String generalComm) {
    this.generalComm = generalComm;
  }

  /**
   * @return Returns the isExist.
   */
  public String getIsExist() {
    return isExist;
  }

  /**
   * @param isExist The isExist to set.
   */
  public void setIsExist(String isExist) {
    this.isExist = isExist;
  }

  /**
   * @return Returns the accierGenderDesc.
   */
  public String getAccierGenderDesc() {
    return accierGenderDesc;
  }

  /**
   * @param accierGenderDesc The accierGenderDesc to set.
   */
  public void setAccierGenderDesc(String accierGenderDesc) {
    this.accierGenderDesc = accierGenderDesc;
  }

  /**
   * @return Returns the accierIdTypeDesc.
   */
  public String getAccierIdTypeDesc() {
    return accierIdTypeDesc;
  }

  /**
   * @param accierIdTypeDesc The accierIdTypeDesc to set.
   */
  public void setAccierIdTypeDesc(String accierIdTypeDesc) {
    this.accierIdTypeDesc = accierIdTypeDesc;
  }

  /**
   * @return Returns the accierIdNumber.
   */
  public String getAccierIdNumber() {
    return accierIdNumber;
  }

  /**
   * @param accierIdNumber The accierIdNumber to set.
   */
  public void setAccierIdNumber(String accierIdNumber) {
    this.accierIdNumber = accierIdNumber;
  }

  /**
   * @return Returns the accierIdType.
   */
  public Integer getAccierIdType() {
    return accierIdType;
  }

  /**
   * @param accierIdType The accierIdType to set.
   */
  public void setAccierIdType(Integer accierIdType) {
    this.accierIdType = accierIdType;
  }

  /**
   * @return Returns the accierName.
   */
  public String getAccierName() {
    return accierName;
  }

  /**
   * @param accierName The accierName to set.
   */
  public void setAccierName(String accierName) {
    this.accierName = accierName;
  }

  /**
   * @return Returns the agentMp.
   */
  public String getAgentMp() {
    return agentMp;
  }

  /**
   * @param agentMp The agentMp to set.
   */
  public void setAgentMp(String agentMp) {
    this.agentMp = agentMp;
  }

  /**
   * @return Returns the rptrZip.
   */
  public String getRptrZip() {
    return rptrZip;
  }

  /**
   * @param rptrZip The rptrZip to set.
   */
  public void setRptrZip(String rptrZip) {
    this.rptrZip = rptrZip;
  }

  /**
   * minimal constructor
   * 
   * @return java.lang.Long
   * @roseuid 411C2BF9008D
   */
  public Long getCaseId() {
    return this.caseId;
  }

  /**
   * @param caseId
   * @roseuid 411C2BF9009C
   */
  public void setCaseId(Long caseId) {
    this.caseId = caseId;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF9009E
   */
  public String getReportType() {
    return this.reportType;
  }

  /**
   * @param reportType
   * @roseuid 411C2BF900AB
   */
  public void setReportType(String reportType) {
    this.reportType = reportType;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF900AD
   */
  public Date getAccidentTime() {
    return this.accidentTime;
  }

  /**
   * @param accidentTime
   * @roseuid 411C2BF900BB
   */
  public void setAccidentTime(Date accidentTime) {
    this.accidentTime = accidentTime;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF90119
   */
  public String getCaseNo() {
    return this.caseNo;
  }

  /**
   * @param caseNo
   * @roseuid 411C2BF9011A
   */
  public void setCaseNo(String caseNo) {
    this.caseNo = caseNo;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF90129
   */
  public Long getInsuredId() {
    return this.insuredId;
  }

  /**
   * @param insuredId
   * @roseuid 411C2BF9012A
   */
  public void setInsuredId(Long insuredId) {
    this.insuredId = insuredId;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF90139
   */
  public Long getReporter() {
    return this.reporter;
  }

  /**
   * @param reporter
   * @roseuid 411C2BF90148
   */
  public void setReporter(Long reporter) {
    this.reporter = reporter;
  }

  /**
   * @return java.lang.Integer
   * @roseuid 411C2BF9014A
   */
  public Integer getRptrRelation() {
    return this.rptrRelation;
  }

  /**
   * @param rptrRelation
   * @roseuid 411C2BF90157
   */
  public void setRptrRelation(Integer rptrRelation) {
    this.rptrRelation = rptrRelation;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF90159
   */
  public Long getRptrAddr() {
    return this.rptrAddr;
  }

  /**
   * @param rptrAddr
   * @roseuid 411C2BF90167
   */
  public void setRptrAddr(Long rptrAddr) {
    this.rptrAddr = rptrAddr;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF90177
   */
  public String getRptrEmail() {
    return this.rptrEmail;
  }

  /**
   * @param rptrEmail
   * @roseuid 411C2BF90178
   */
  public void setRptrEmail(String rptrEmail) {
    this.rptrEmail = rptrEmail;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF90196
   */
  public String getRptrMp() {
    return this.rptrMp;
  }

  /**
   * @param rptrMp
   * @roseuid 411C2BF90197
   */
  public void setRptrMp(String rptrMp) {
    this.rptrMp = rptrMp;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF901A6
   */
  public String getRptrTel() {
    return this.rptrTel;
  }

  /**
   * @param rptrTel
   * @roseuid 411C2BF901A7
   */
  public void setRptrTel(String rptrTel) {
    this.rptrTel = rptrTel;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF901B6
   */
  public String getIsRpterSms() {
    return this.isRpterSms;
  }

  /**
   * @param isRpterSms
   * @roseuid 411C2BF901C5
   */
  public void setIsRpterSms(String isRpterSms) {
    this.isRpterSms = isRpterSms;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF901D4
   */
  public Long getRegistrarId() {
    return this.registrarId;
  }

  /**
   * @param registrarId
   * @roseuid 411C2BF901D5
   */
  public void setRegistrarId(Long registrarId) {
    this.registrarId = registrarId;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF901E5
   */
  public Long getAgentId() {
    return this.agentId;
  }

  /**
   * @param agentId
   * @roseuid 411C2BF901E6
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  /**
   * @return java.lang.String
   * @roseuid 411C2BF901F5
   */
  public String getIsAgentSms() {
    return this.isAgentSms;
  }

  /**
   * @param isAgentSms
   * @roseuid 411C2BF90203
   */
  public void setIsAgentSms(String isAgentSms) {
    this.isAgentSms = isAgentSms;
  }

  /**
   * @return java.lang.Long
   * @roseuid 411C2BF90223
   */
  public Long getRecorderId() {
    return this.recorderId;
  }

  /**
   * @param recorderId
   * @roseuid 411C2BF90232
   */
  public void setRecorderId(Long recorderId) {
    this.recorderId = recorderId;
  }

  /**
   * @return Returns the policyType.
   * @roseuid 411C2BF90261
   */
  public Integer getPolicyType() {
    return policyType;
  }

  /**
   * @param policyType The policyType to set.
   * @roseuid 411C2BF90271
   */
  public void setPolicyType(Integer policyType) {
    this.policyType = policyType;
  }

  /**
   * @return Returns the caseStatus.
   * @roseuid 411C2BF90280
   */
  public Integer getCaseStatus() {
    return caseStatus;
  }

  /**
   * @param caseStatus The caseStatus to set.
   * @roseuid 411C2BF90290
   */
  public void setCaseStatus(Integer caseStatus) {
    this.caseStatus = caseStatus;
  }

  /**
   * @return Returns the claimType.
   */
  public Integer getClaimType() {
    return claimType;
  }

  /**
   * @param claimType The claimType to set.
   */
  public void setClaimType(Integer claimType) {
    this.claimType = claimType;
  }

  /**
   * @return Returns the agentName.
   */
  public String getAgentName() {
    return agentName;
  }

  /**
   * @param agentName The agentName to set.
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  /**
   * @return Returns the accierGender.
   */
  public String getAccierGender() {
    return accierGender;
  }

  /**
   * @param accierGender The accierGender to set.
   */
  public void setAccierGender(String accierGender) {
    this.accierGender = accierGender;
  }

  /**
   * @return Returns the address1.
   */
  public String getAddress1() {
    return address1;
  }

  /**
   * @param address1 The address1 to set.
   */
  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  /**
   * @return Returns the address2.
   */
  public String getAddress2() {
    return address2;
  }

  /**
   * @param address2 The address2 to set.
   */
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  /**
   * @return Returns the address3.
   */
  public String getAddress3() {
    return address3;
  }

  /**
   * @param address3 The address3 to set.
   */
  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  /**
   * @return Returns the address4.
   */
  public String getAddress4() {
    return address4;
  }

  /**
   * @param address4 The address4 to set.
   */
  public void setAddress4(String address4) {
    this.address4 = address4;
  }

  /**
   * @return Returns the registerTime.
   */
  public Date getRegisterTime() {
    return registerTime;
  }

  /**
   * @param registerTime The registerTime to set.
   */
  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

  /**
   * @return Returns the updaterId.
   */
  public Long getUpdaterId() {
    return updaterId;
  }

  /**
   * @param updaterId The updaterId to set.
   */
  public void setUpdaterId(Long updaterId) {
    this.updaterId = updaterId;
  }

  /**
   * @return Returns the policyTypes.
   */
  public Integer[] getPolicyTypes() {
    return policyTypes;
  }

  /**
   * @param policyTypes The policyTypes to set.
   */
  public void setPolicyTypes(Integer[] policyTypes) {
    this.policyTypes = policyTypes;
  }

  /**
   * @return Returns the agentCode.
   */
  public String getAgentCode() {
    return agentCode;
  }

  /**
   * @param agentCode The agentCode to set.
   */
  public void setAgentCode(String agentCode) {
    this.agentCode = agentCode;
  }

  /**
   * @return Returns the nextOfficerId.
   */
  public Long getNextOfficerId() {
    return nextOfficerId;
  }

  /**
   * @param nextOfficerId The nextOfficerId to set.
   */
  public void setNextOfficerId(Long nextOfficerId) {
    this.nextOfficerId = nextOfficerId;
  }

  /**
   * @return Returns the operId.
   */
  public Long getOperId() {
    return operId;
  }

  /**
   * @param operId The operId to set.
   */
  public void setOperId(Long operId) {
    this.operId = operId;
  }

  /**
   * @return Returns the operOrg.
   */
  public Long getOperOrg() {
    return operOrg;
  }

  /**
   * @param operOrg The operOrg to set.
   */
  public void setOperOrg(Long operOrg) {
    this.operOrg = operOrg;
  }

  public String getAddress5() {
    return address5;
  }

  public void setAddress5(String address5) {
    this.address5 = address5;
  }

  public String getAddress6() {
    return address6;
  }

  public void setAddress6(String address6) {
    this.address6 = address6;
  }

  public String getAddress7() {
    return address7;
  }

  public void setAddress7(String address7) {
    this.address7 = address7;
  }

  public String getAddress8() {
    return address8;
  }

  public void setAddress8(String address8) {
    this.address8 = address8;
  }

  /**
   * @return Returns the rptrName.
   */
  public String getRptrName() {
    return rptrName;
  }

  /**
   * @param rptrName The rptrName to set.
   */
  public void setRptrName(String rptrName) {
    this.rptrName = rptrName;
  }

  public Date getApplyDocDate() {
    return applyDocDate;
  }

  public void setApplyDocDate(Date applyDocDate) {
    this.applyDocDate = applyDocDate;
  }

  public Date getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(Date deathDate) {
    this.deathDate = deathDate;
  }

  public Date getBranchNotificationDate() {
    return branchNotificationDate;
  }

  public void setBranchNotificationDate(Date branchNotificationDate) {
    this.branchNotificationDate = branchNotificationDate;
  }

  public Long getReceiveBranch() {
    return receiveBranch;
  }

  public void setReceiveBranch(Long receiveBranch) {
    this.receiveBranch = receiveBranch;
  }

  public Integer getClmtType() {
    return clmtType;
  }

  public void setClmtType(Integer clmtType) {
    this.clmtType = clmtType;
  }

  public String getClmtName() {
    return clmtName;
  }

  public void setClmtName(String clmtName) {
    this.clmtName = clmtName;
  }

  public String getClaimantAddress() {
    return claimantAddress;
  }

  public void setClaimantAddress(String claimantAddress) {
    this.claimantAddress = claimantAddress;
  }

  public Long getClmtAddr() {
    return clmtAddr;
  }

  public void setClmtAddr(Long clmtAddr) {
    this.clmtAddr = clmtAddr;
  }

  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }

  public String getEventLocation() {
    return eventLocation;
  }

  public void setEventLocation(String eventLocation) {
    this.eventLocation = eventLocation;
  }

  public String getEventDetails() {
    return eventDetails;
  }

  public void setEventDetails(String eventDetails) {
    this.eventDetails = eventDetails;
  }

  public Date getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(Date admissionDate) {
    this.admissionDate = admissionDate;
  }

  public Date getDischargeDate() {
    return dischargeDate;
  }

  public void setDischargeDate(Date dischargeDate) {
    this.dischargeDate = dischargeDate;
  }

  public String getDeathCode() {
    return deathCode;
  }

  public void setDeathCode(String deathCode) {
    this.deathCode = deathCode;
  }

  public String getIncidentCode() {
    return incidentCode;
  }

  public void setIncidentCode(String incidentCode) {
    this.incidentCode = incidentCode;
  }

  public String getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
  }

  public String getDiagnosisCode() {
    return diagnosisCode;
  }

  public void setDiagnosisCode(String diagnosisCode) {
    this.diagnosisCode = diagnosisCode;
  }

  public String getSurgeryId() {
    return surgeryId;
  }

  public void setSurgeryId(String surgeryId) {
    this.surgeryId = surgeryId;
  }

  public Date getSurgeryDate() {
    return surgeryDate;
  }

  public void setSurgeryDate(Date surgeryDate) {
    this.surgeryDate = surgeryDate;
  }
}
