package com.flywolf.li.framework.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public abstract class AuditEntity implements Serializable {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  // Who created
  @Column(name = "INSERTED_BY")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Long insertedBy;
  // Who updated at latest
  @Column(name = "UPDATED_BY")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Long updatedBy;
  // When created at system time
  @Column(name = "INSERT_TIMESTAMP")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Date insertTimestamp;
  // When updated at latest at system time
  @Column(name = "UPDATE_TIMESTAMP")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Date updateTimestamp;
  // When created at application time
  @Column(name = "INSERT_TIME")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Date insertTime;
  // When updated at latest at application time
  @Column(name = "UPDATE_TIME")
  @ApiModelProperty(hidden = true)
  @JsonIgnore
  protected Date updateTime;

  public Date getInsertTimestamp() {
    return insertTimestamp;
  }

  public Long getInsertedBy() {
    return insertedBy;
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public Long getUpdatedBy() {
    return updatedBy;
  }

  public Date getUpdateTimestamp() {
    return updateTimestamp;
  }

  public void setInsertedBy(Long insertedBy) {
    this.insertedBy = insertedBy;
  }

  public void setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  public void setInsertTimestamp(Date insertTimestamp) {
    this.insertTimestamp = insertTimestamp;
  }

  public void setUpdateTimestamp(Date updateTimestamp) {
    this.updateTimestamp = updateTimestamp;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
