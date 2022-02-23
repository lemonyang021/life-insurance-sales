package com.flywolf.li.code;

public enum RiskStatus implements Id {
  NonValidation(0), Inforce(1), Lapsed(2), Terminated(3);

  private final int id;

  private RiskStatus(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
