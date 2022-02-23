package com.flywolf.li.framework.encrypt.hibernate;

public class DBEncryptRuntimeException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -3831856733475803080L;

  public DBEncryptRuntimeException(String msg) {
    super(msg);
  }
  
  public DBEncryptRuntimeException(Throwable e) {
    super(e);
  }
}
