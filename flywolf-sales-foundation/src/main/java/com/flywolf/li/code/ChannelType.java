package com.flywolf.li.code;

public enum ChannelType implements Id {
  TiedAgent(1), Bancassurance(2), Telemarketing(3), DirectMail(4), Agency(5), Broker(6);

  private final int id;

  private ChannelType(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
