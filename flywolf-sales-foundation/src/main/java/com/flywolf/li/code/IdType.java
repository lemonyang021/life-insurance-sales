package com.flywolf.li.code;

public enum IdType implements Id {
  IdCard(1), Passport(3), others(9);

  private final int id;

  private IdType(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }

}
