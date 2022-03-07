package com.flywolf.li.framework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class AuditEntity implements Serializable {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  // Who created
  @Column(name = "INSERTED_BY")
  @Schema(hidden = true)
  @JsonIgnore
  protected Long insertedBy;
  // Who updated at latest
  @Column(name = "UPDATED_BY")
  @Schema(hidden = true)
  @JsonIgnore
  protected Long updatedBy;
  // When created at system time
  @Column(name = "INSERT_TIMESTAMP")
  @Schema(hidden = true)
  @JsonIgnore
  protected Date insertTimestamp;
  // When updated at latest at system time
  @Column(name = "UPDATE_TIMESTAMP")
  @Schema(hidden = true)
  @JsonIgnore
  protected Date updateTimestamp;
  // When created at application time
  @Column(name = "INSERT_TIME")
  @Schema(hidden = true)
  @JsonIgnore
  protected Date insertTime;
  // When updated at latest at application time
  @Column(name = "UPDATE_TIME")
  @Schema(hidden = true)
  @JsonIgnore
  protected Date updateTime;


}
