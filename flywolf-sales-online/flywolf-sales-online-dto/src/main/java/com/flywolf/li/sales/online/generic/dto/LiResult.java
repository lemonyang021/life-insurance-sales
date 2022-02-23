package com.flywolf.li.sales.online.generic.dto;

import org.apache.commons.lang.ArrayUtils;

import java.io.Serializable;

public class LiResult implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -1186051017042101091L;
  private ServiceResultCode result;
  private GenericValidationResult[] messages;
  private String[] exceptions;

  public ServiceResultCode getResult() {
    return result;
  }

  public void setResult(ServiceResultCode result) {
    this.result = result;
  }

  public GenericValidationResult[] getMessages() {
    return messages;
  }

  public void setMessages(GenericValidationResult[] messages) {
    this.messages = messages;
  }

  public String[] getExceptions() {
    return exceptions;
  }

  public void setExceptions(String[] exceptions) {
    this.exceptions = exceptions;
  }

  public void addMessage(String message) {
    addMessage(null, message);
  }

  public void addMessage(String code, String message) {
    addMessage(null, code, message);
  }

  public void addMessage(Integer ruleType, String code, String message) {
    if (this.messages == null) {
      this.messages = new GenericValidationResult[] {};
    }
    GenericValidationResult result = new GenericValidationResult();
    result.setRuleType(ruleType);
    result.setMessage(message);
    result.setCode(code);
    this.messages = (GenericValidationResult[]) ArrayUtils.add(this.messages, result);
  }

}
