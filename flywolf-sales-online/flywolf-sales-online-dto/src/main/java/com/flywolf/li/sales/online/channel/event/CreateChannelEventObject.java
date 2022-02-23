package com.flywolf.li.sales.online.channel.event;

import com.flywolf.li.sales.online.generic.dto.LiResult;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateChannelEventObject<REQ extends Serializable, RES extends Serializable>
    implements Serializable {

  private static final long serialVersionUID = 684644740301607778L;
  private String tenantCode;
  private String insurerCode;
  private Boolean isMocked;
  private LiResult result = new LiResult();
  private REQ request;
  private RES response;
  private String channelCode;
}
