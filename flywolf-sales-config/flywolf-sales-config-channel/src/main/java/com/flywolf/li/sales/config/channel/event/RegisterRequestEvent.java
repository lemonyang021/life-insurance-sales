package com.flywolf.li.sales.config.channel.event;

import org.springframework.context.ApplicationEvent;

public class RegisterRequestEvent extends ApplicationEvent {
  /**
   * 
   */
  private static final long serialVersionUID = -737712349712977197L;
  
  public RegisterRequestEvent(RegisterEventObject source) {
    super(source);
  }
}
