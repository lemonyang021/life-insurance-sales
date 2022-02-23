package com.flywolf.li.sales.online.channel.dto;

import com.flywolf.li.sales.online.generic.dto.GenericLiRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateChannelRequest extends GenericLiRequest {

  /**
   * 
   */
  private static final long serialVersionUID = 6805402092950553743L;


  @ApiModelProperty(value = "Sales Channel Code", position = 1)
  private String channelCode;

  @ApiModelProperty(value = "Sales Channel name", position = 2)
  private String channelName;

  public CreateChannelRequest(boolean autoFill) {
    super(autoFill);
  }
}
