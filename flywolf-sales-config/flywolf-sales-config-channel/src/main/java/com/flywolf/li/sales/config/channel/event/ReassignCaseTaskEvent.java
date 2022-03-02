package com.flywolf.li.sales.config.channel.event;


import org.springframework.context.ApplicationEvent;

public class ReassignCaseTaskEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8581766566475316240L;


  public ReassignCaseTaskEvent(Object source) {
    super(source);
  }
}
