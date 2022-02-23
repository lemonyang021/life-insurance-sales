package com.flywolf.li.code;

public enum PreferredLifeIndi implements Code {
  NA("0"), PrefferedLifeClass1("1"), PrefferedLifeClass2("2"), PrefferedLifeClass3(
      "3"), PrefferedLifeClass4("4"), NonPrefferedLifeClass1("5"), NonPrefferedLifeClass2("6");

  private final String code;

  private PreferredLifeIndi(String code) {
    this.code = code;
  }

  @Override
  public String code() {
    return code;
  }


}
