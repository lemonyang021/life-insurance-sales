package com.flywolf.li.code;

public enum Gender implements CodeWithDescription {
  M("Male"), F("Female"), T("TransGender"), N("NA");

  private final String description;

  private Gender(String description) {
    this.description = description;
  }

  @Override
  public String code() {
    return this.name();
  }

  @Override
  public String description() {
    return description;
  }
}
