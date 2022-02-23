package com.flywolf.li.framework.jpa;

public enum CriteriaMatchType {
  equal, // filed = value
  gt, // filed > value
  ge, // field >= value
  lt, // field < value
  le, // field <= value
  notEqual, // field != value
  like, // field like value
  notLike, // field not like value
  greaterThan, // field > value
  greaterThanOrEqualTo, // field >= value
  lessThan, // field < value
  lessThanOrEqualTo, // field <= value
  ;
}
