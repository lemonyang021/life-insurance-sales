package com.flywolf.li.sales.online.context;

import com.flywolf.li.framework.web.ServiceHeader;

public class GenericSalesOnlineContext implements java.io.Serializable {
  private static final long serialVersionUID = -430018312175657980L;

  private ServiceHeader header;

  private String insurerCode;

  public ServiceHeader getHeader() {
    return header;
  }

  public void setHeader(ServiceHeader header) {
    this.header = header;
  }

  public String getInsurerCode() {
    return insurerCode;
  }

  public void setInsurerCode(String insurerCode) {
    this.insurerCode = insurerCode;
  }

}
