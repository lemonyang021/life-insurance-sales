package com.flywolf.li.framework.exception;


import com.flywolf.li.framework.dto.GenericLiResponse;

public class LiClientException extends GenericLiException {
  /**
   * 
   */
  private static final long serialVersionUID = 5456695840209987134L;

  public LiClientException(GenericLiResponse failedResponse) {
    super(failedResponse);
  }

  public LiClientException(GenericLiResponse failedResponse, Throwable cause) {
    super(failedResponse, cause);
  }

}
