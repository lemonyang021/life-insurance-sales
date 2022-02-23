package com.flywolf.li.code;

public enum ProspectType implements Id {
  Exists(1), Latency(2);

  private final int id;

  private ProspectType(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
