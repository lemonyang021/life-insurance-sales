package com.flywolf.li.framework.entity;

import com.ebao.li.flywolf.sales.dto.generic.IExtendableDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 审计对象，所有数据库实体类都包含的公共字段
 */

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class ExtendableAuditEntity {
    // Who created
    @Column(name = "INSERTED_BY")
    @ApiModelProperty(hidden = true)
    protected Long insertedBy;
    // Who updated at latest
    @Column(name = "UPDATED_BY")
    @ApiModelProperty(hidden = true)
    protected Long updatedBy;
    // When created at system time
    @Column(name = "INSERT_TIMESTAMP")
    @ApiModelProperty(hidden = true)
    protected Date insertTimestamp;
    // When updated at latest at system time
    @Column(name = "UPDATE_TIMESTAMP")
    @ApiModelProperty(hidden = true)
    protected Date updateTimestamp;
    // When created at application time
    @Column(name = "INSERT_TIME")
    @ApiModelProperty(hidden = true)
    protected Date insertTime;
    // When updated at latest at application time
    @Column(name = "UPDATE_TIME")
    @ApiModelProperty(hidden = true)
    protected Date updateTime;

    //以下属性不存DB,只是保存在内存对象中
    @Transient
    private Map<String, String> extraProps = new HashMap<String, String>();

    @Transient
    private String serializedExtensionObj;

}
