package com.flywolf.li.sales.online.channel.event;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateChannelEventObject<REQ extends Serializable, RES extends Serializable>
    implements Serializable {

  private static final long serialVersionUID = 684644740301607778L;
  private REQ request;
  private RES response;
  private String channelCode;
}
