package com.flywolf.li.code;

public enum AccountType implements Code {
  DirectDebit("2"), CreditCard("8");

  private final String code;

  private AccountType(String code) {
    this.code = code;
  }

  @Override
  public String code() {
    return code;
  }

}
