package com.flywolf.li.framework.exception;

import org.springframework.context.MessageSourceResolvable;

public class LiIllegalArgumentException extends IllegalArgumentException {

  /**
   * 
   */
  private static final long serialVersionUID = 7395782181538614786L;

  private final MessageSourceResolvable resolvable;

  public LiIllegalArgumentException(MessageSourceResolvable resolvable) {
    super();
    this.resolvable = resolvable;
  }

  public LiIllegalArgumentException(MessageSourceResolvable resolvable, Throwable cause) {
    super(cause);
    this.resolvable = resolvable;
  }

  public MessageSourceResolvable getResolvable() {
    return resolvable;
  }



}
