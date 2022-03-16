package com.flywolf.li.framework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 审计对象，所有数据库实体类都包含的公共字段
 */

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class BaseEntity {
    // Who created
    @Column(name = "INSERTED_BY")
    @Schema(hidden = true)
    protected Long insertedBy;
    // Who updated at latest
    @Column(name = "UPDATED_BY")
    @Schema(hidden = true)
    protected Long updatedBy;
    // When created at application time
    @Column(name = "INSERT_TIME")
    @Schema(hidden = true)
    protected Date insertTime;
    // When updated at latest at application time
    @Column(name = "UPDATE_TIME")
    @Schema(hidden = true)
    protected Date updateTime;

}
