package com.flywolf.li.sales.online.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class ValidationResult extends GenericValidationResult {
  private static final long serialVersionUID = 7651094982118868240L;
  public static final String MESSAGE_LEVEL__ERROR = "ERROR";
  public static final String MESSAGE_LEVEL__WARN = "WARN";

  public static final String NO_RECORD_FOUND_CODE = "20451020012";
  public static final ValidationResult NO_RECORD_FOUND =
      getWarnInstance(NO_RECORD_FOUND_CODE, null);
  /**
   * use code as rule name
   */
  private String langId;
  private Map<String, Object> messageProps;
  // 校验规则级别
  private String messageLevel;
  // 校验规则校验结果
  private boolean passed = false;

  private ValidationResult() {}

  public ValidationResult(String errorCode, String errorMessage) {
    this.code = errorCode;
    this.message = errorMessage;
    this.messageLevel = MESSAGE_LEVEL__ERROR;
  }

  @JsonIgnore
  public static ValidationResult getPassedErrorInstance(String code) {
    ValidationResult result = new ValidationResult();
    result.code = code;
    result.messageLevel = MESSAGE_LEVEL__ERROR;
    result.passed = true;
    return result;
  }

  @JsonIgnore
  public static ValidationResult getPassedWarnInstance(String code) {
    return getPassedWarnInstance(code, null, null);
  }

  @JsonIgnore
  public static ValidationResult getPassedWarnInstance(String code, String message) {
    return getPassedWarnInstance(code, null, message);
  }

  @JsonIgnore
  public static ValidationResult getPassedWarnInstance(String code,
      Map<String, Object> messageProps, String message) {
    ValidationResult result = new ValidationResult();
    result.code = code;
    result.messageProps = messageProps;
    result.message = message;
    result.messageLevel = MESSAGE_LEVEL__WARN;
    result.passed = true;
    return result;
  }


  @JsonIgnore
  public static ValidationResult getErrorInstance(String code, String message) {
    return getErrorInstance(code, null, message);
  }

  @JsonIgnore
  public static ValidationResult getErrorInstance(String code, Map<String, Object> messageProps,
      String message) {
    ValidationResult result = new ValidationResult();
    result.code = code;
    result.messageProps = messageProps;
    result.message = message;
    result.messageLevel = MESSAGE_LEVEL__ERROR;
    return result;
  }

  @JsonIgnore
  public static ValidationResult getWarnInstance(String code, String message) {
    return getWarnInstance(code, null, message);
  }

  @JsonIgnore
  public static ValidationResult getWarnInstance(String code, Map<String, Object> messageProps,
      String message) {
    ValidationResult result = new ValidationResult();
    result.code = code;
    result.messageProps = messageProps;
    result.message = message;
    result.messageLevel = MESSAGE_LEVEL__WARN;
    return result;
  }

  @JsonIgnore
  public boolean isError() {
    return ValidationResult.MESSAGE_LEVEL__ERROR.equals(messageLevel);
  }

  @JsonIgnore
  public boolean isWarning() {
    return ValidationResult.MESSAGE_LEVEL__WARN.equals(messageLevel);
  }

  @JsonIgnore
  public boolean violated() {
    return !passed;
  }

  public void setLangId(String langId) {
    this.langId = langId;
  }

  @JsonIgnore
  public Map<String, Object> getMessageProps() {
    return messageProps;
  }

  public void setMessageProps(Map<String, Object> messageProps) {
    this.messageProps = messageProps;
  }

  @JsonIgnore
  public String getLangId() {
    return langId;
  }

  @Override
  public String getMessage() {
    return getMessage(langId);
  }

  @JsonIgnore
  public String getTranslatedMessage() {
    return this.message;
  }

  public String getMessage(String langId) {
    try {
      /*ValidationResultMessageSPI instance = ValidationResultMessageFactory.instance();
      if (instance != null) {
        return instance.getMessage(this);
      }*/
    } catch (Exception e) {
       //TODO
    }
    return getTranslatedMessage();
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public Integer getRuleType() {
    return ruleType;
  }

  @Override
  public void setRuleType(Integer ruleType) {
    this.ruleType = ruleType;
  }

  public String getMessageLevel() {
    return messageLevel;
  }

  public void setMessageLevel(String messageLevel) {
    if (MESSAGE_LEVEL__ERROR.equals(messageLevel) || MESSAGE_LEVEL__WARN.equals(messageLevel)) {
      this.messageLevel = messageLevel;
    } else {
      throw new IllegalArgumentException(messageLevel);
    }
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 37 * result + (code == null ? 0 : this.code.hashCode());
    result = 37 * result + (message == null ? 0 : this.message.hashCode());
    result = 37 * result + (messageProps == null ? 0 : this.messageProps.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (!(other instanceof ValidationResult)) {
      return false;
    }
    ValidationResult castOther = (ValidationResult) other;

    return (this.code == castOther.code
        || this.code != null && castOther.code != null && this.code.equals(castOther.code))
        && (this.message == castOther.message || this.message != null && castOther.message != null
            && this.message.equals(castOther.message))
        && (this.messageProps == castOther.messageProps || this.messageProps != null
            && castOther.messageProps != null && this.messageProps.equals(castOther.messageProps));

  }

}
