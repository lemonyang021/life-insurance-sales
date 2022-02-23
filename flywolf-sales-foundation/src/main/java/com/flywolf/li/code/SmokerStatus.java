package com.flywolf.li.code;

public enum SmokerStatus implements CodeWithDescription {
  Y("Smoker"), N("Non-Smoker"), E("Ex-Smoker"), W("N/A");

  private final String description;

  private SmokerStatus(String description) {
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
