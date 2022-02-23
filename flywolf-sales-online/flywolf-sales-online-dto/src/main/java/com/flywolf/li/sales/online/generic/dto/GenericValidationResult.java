package com.flywolf.li.sales.online.generic.dto;

public class GenericValidationResult implements IValidationResult {

  private static final long serialVersionUID = -6369783688251601411L;

  protected String code;

  protected String message;

  protected Integer ruleType = 1;

  @Override
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public Integer getRuleType() {
    return ruleType;
  }

  @Override
  public void setRuleType(Integer ruleType) {
    this.ruleType = ruleType;
  }


}
