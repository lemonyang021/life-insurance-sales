package com.flywolf.li.jdbc;

public class ClaimBsSequenceInfo {
  
  private String sequenceName;
  private long nextNumber;
  private int incrementBy;
  private int cacheSize;

  public int getCacheSize() {
      return cacheSize;
  }
  public void setCacheSize(int cacheSize) {
      this.cacheSize = cacheSize;
  }

  public String getSequenceName() {
    return sequenceName;
  }
  public void setSequenceName(String sequenceName) {
    this.sequenceName = sequenceName;
  }
  public long getNextNumber() {
    return nextNumber;
  }
  public void setNextNumber(long nextNumber) {
    this.nextNumber = nextNumber;
  }
  public int getIncrementBy() {
    return incrementBy;
  }
  public void setIncrementBy(int incrementBy) {
    this.incrementBy = incrementBy;
  }
  
  @Override
  public String toString() {
      return "ClaimBsSequenceInfo [sequenceName=" + sequenceName
              + ", incrementBy=" + incrementBy + ", cacheSize=" + cacheSize + ", nextNumber=" + nextNumber
              + "]";
  }
  
}
