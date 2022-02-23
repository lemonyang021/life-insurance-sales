package com.flywolf.li.sales.online.channel.event;

import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import com.flywolf.li.sales.online.channel.dto.CreateChannelResponse;
import org.springframework.context.ApplicationEvent;

public class CreateChannelEvent extends ApplicationEvent {

  private static final long serialVersionUID = 4015292667656976592L;

  public CreateChannelEvent(CreateChannelEventObject<CreateChannelRequest, CreateChannelResponse> source) {
    super(source);
  }

}
