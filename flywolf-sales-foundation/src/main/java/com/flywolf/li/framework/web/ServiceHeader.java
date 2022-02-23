package com.flywolf.li.framework.web;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceHeader implements Serializable {

  private static final long serialVersionUID = 6621278149557446356L;

  private String xtenantId;
  private String xfirstEndPoint;
  private String contractorCode;
  private String brokerCode;
  private String channelCode;
}
