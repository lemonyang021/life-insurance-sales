package com.flywolf.li.code;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AlterationEffectiveType implements Code {
  NOT_SUPPORT("0"), //
  FromInceptionDate("1"), //
  Immediately("2"), //
  FromLastDueDate("3"), //
  FromNextDueDate("4"), //
  FromLastAnniversaryDate("5"), //
  FromNextAnniversaryDate("6"), //
  FromLapseDate("7"), //
  FromNextMonthlyversaryDate("8"), //
  FromNextHalfAnniversaryYear("9"), //
  FromReservedDate("10");

  private final String code;

  private AlterationEffectiveType(String code) {
    this.code = code;
  }

  @Override
  @JsonValue
  public String code() {
    return code;
  }

}
