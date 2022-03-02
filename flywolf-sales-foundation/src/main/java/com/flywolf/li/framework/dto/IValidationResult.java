package com.flywolf.li.framework.dto;

import java.io.Serializable;

public interface IValidationResult extends Serializable {
  String getCode();
  
  String getMessage();
  
  Integer getRuleType();
  
  void setRuleType(Integer ruleType);
}
