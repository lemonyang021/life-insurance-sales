package com.flywolf.li.framework.security;

import java.io.Serializable;

public class OauthProfile implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 475411228914882715L;
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
