package com.flywolf.li.sales.online.generic.dto;

public class GenericClientServiceResponse extends SimpleClientServiceResponse {

  private static final long serialVersionUID = 2618459741080687552L;

  public final static GenericClientServiceResponse SUCCESS = new GenericClientServiceResponse();

  public GenericClientServiceResponse() {
    super.setResult(ServiceResultCode.SUCCEEDED);
  }

  @Override
  public ValidationResult[] getMessages() {
    return (ValidationResult[]) super.getMessages();
  }

  public void setMessages(ValidationResult[] messages) {
    super.setMessages(messages);
  }

}
