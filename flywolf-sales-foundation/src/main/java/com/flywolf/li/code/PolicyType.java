package com.flywolf.li.code;

public enum PolicyType implements Id {
  IndividualInsurance(1), GroupBiz(2), Bancassurance(3);

  private final int id;

  private PolicyType(int id) {
    this.id = id;
  }

  @Override
  public int id() {
    return id;
  }

}
