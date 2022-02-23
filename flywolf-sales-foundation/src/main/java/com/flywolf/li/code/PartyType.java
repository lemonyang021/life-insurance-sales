package com.flywolf.li.code;

public enum PartyType implements Id {
  Person(1), Organization(2);

  private final int id;

  private PartyType(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }

}
