package com.flywolf.li.sales.config.channel.vo;

import com.ebao.li.flywolf.sales.dto.generic.GenericVO;

public class LifeAssuredVO extends GenericVO {

  private String certiType = "";
  private String certiCode = "";
  private String customerId = "";
  private String gender = "";
  private String firstName = "";
  private String agentId = "";
  private String agentCode = "";
  private String agentName = "";
  private String agentHpNumber = "";
  //for single quotes
  private String arguFirstName = "";
  private String arguAgentName = "";

  //added for LCS stand alone by robert.xu on 2008.9.17
  private String email = "";
  private String homeTel = "";
  private String mobilePhone = "";
  private String addressId = "";
  private String address1 = "";
  private String address2 = "";
  private String address3 = "";
  private String address4 = "";
  private String address5 = "";
  private String address6 = "";
  private String address7 = "";
  private String postCode = "";
  //added end

  /*
   * ADD START by boyd.wu Oct 10, 2009 CRDB00368164
   * The related policies are not correctly displayed
   */
  private String relatedPolicies = "";
  /*
   * ADD END by boyd.wu Oct 10, 2009 CRDB00368164
   */

  //added by weiping.zhao on 2009-03-24 for fukoku
  private String birthDay;
  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
  }
  public String getBirthDay() {
    return birthDay;
  }
  //added end
  /**
   * @return Returns the arguAgentName.
   */
  public String getArguAgentName() {
    return arguAgentName;
  }

  /**
   * @param arguAgentName The arguAgentName to set.
   */
  public void setArguAgentName(String arguAgentName) {
    this.arguAgentName = arguAgentName;
  }

  /**
   * @return Returns the arguFirstName.
   */
  public String getArguFirstName() {
    return arguFirstName;
  }

  /**
   * @param arguFirstName The arguFirstName to set.
   */
  public void setArguFirstName(String arguFirstName) {
    this.arguFirstName = arguFirstName;
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
   * @return Returns the certiCode.
   */
  public String getCertiCode() {
    return certiCode;
  }

  /**
   * @param certiCode
   *          The certiCode to set.
   */
  public void setCertiCode(String certiCode) {
    this.certiCode = certiCode;
  }

  /**
   * @return Returns the certiType.
   */
  public String getCertiType() {
    return certiType;
  }

  /**
   * @param certiType
   *          The certiType to set.
   */
  public void setCertiType(String certiType) {
    this.certiType = certiType;
  }

  /**
   * @return Returns the customerId.
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId
   *          The customerId to set.
   */
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   * @return Returns the firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   *          The firstName to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return Returns the gender.
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender
   *          The gender to set.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return Returns the agentHpNumber.
   */
  public String getAgentHpNumber() {
    return agentHpNumber;
  }

  /**
   * @param agentHpNumber
   *          The agentHpNumber to set.
   */
  public void setAgentHpNumber(String agentHpNumber) {
    this.agentHpNumber = agentHpNumber;
  }

  /**
   * @return Returns the agentId.
   */
  public String getAgentId() {
    return agentId;
  }

  /**
   * @param agentId
   *          The agentId to set.
   */
  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }

  /**
   * @return Returns the agentName.
   */
  public String getAgentName() {
    return agentName;
  }

  /**
   * @param agentName
   *          The agentName to set.
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setHomeTel(String homeTel) {
    this.homeTel = homeTel;
  }

  public String getHomeTel() {
    return homeTel;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  public String getAddressId() {
    return addressId;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  public String getAddress3() {
    return address3;
  }

  public void setAddress4(String address4) {
    this.address4 = address4;
  }

  public String getAddress4() {
    return address4;
  }

  public void setAddress5(String address5) {
    this.address5 = address5;
  }

  public String getAddress5() {
    return address5;
  }

  public void setAddress6(String address6) {
    this.address6 = address6;
  }

  public String getAddress6() {
    return address6;
  }

  public void setAddress7(String address7) {
    this.address7 = address7;
  }

  public String getAddress7() {
    return address7;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setRelatedPolicies(String relatedPolicies) {
    this.relatedPolicies = relatedPolicies;
  }

  public String getRelatedPolicies() {
    return this.relatedPolicies;
  }

}