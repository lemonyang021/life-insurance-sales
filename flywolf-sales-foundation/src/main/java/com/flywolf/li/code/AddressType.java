package com.flywolf.li.code;

public enum AddressType implements Id {
  Residential(1), Correspondence(2), Other(9);

  private final int id;

  private AddressType(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
