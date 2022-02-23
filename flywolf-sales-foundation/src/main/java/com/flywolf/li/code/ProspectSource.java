package com.flywolf.li.code;

public enum ProspectSource implements Id {
  BySelf(1), ByClient(2);

  private final int id;

  private ProspectSource(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
