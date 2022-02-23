package com.flywolf.li.framework.exception;


import com.ebao.li.flywolf.sales.dto.generic.GenericLiResponse;

public class GenericLiException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = -707854462555863255L;
  private final GenericLiResponse failedResponse;

  public GenericLiException(GenericLiResponse failedResponse) {
    super();
    this.failedResponse = failedResponse;
  }

  public GenericLiException(GenericLiResponse failedResponse, Throwable cause) {
    super(cause);
    this.failedResponse = failedResponse;
  }

  public GenericLiResponse getFailedResponse() {
    return failedResponse;
  }
}
