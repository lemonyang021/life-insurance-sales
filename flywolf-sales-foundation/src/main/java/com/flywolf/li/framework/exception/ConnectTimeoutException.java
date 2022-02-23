package com.flywolf.li.framework.exception;

public class ConnectTimeoutException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 2980240795281560908L;

  private final String serviceName;

  public ConnectTimeoutException(String serviceName) {
    super();
    this.serviceName = serviceName;
  }
  
  public ConnectTimeoutException(String serviceName, Throwable cause) {
    super(cause);
    this.serviceName = serviceName;
  }

  public String getServiceName() {
    return serviceName;
  }

}
