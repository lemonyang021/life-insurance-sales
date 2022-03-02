package com.flywolf.li.framework.exception;


import com.flywolf.li.framework.dto.GenericLiResponse;

public class LiServerException extends GenericLiException {
  /**
   * 
   */
  private static final long serialVersionUID = 3181480637303831131L;

  public LiServerException(GenericLiResponse failedResponse) {
    super(failedResponse);
  }

  public LiServerException(GenericLiResponse failedResponse, Throwable cause) {
    super(failedResponse, cause);
  }

}
