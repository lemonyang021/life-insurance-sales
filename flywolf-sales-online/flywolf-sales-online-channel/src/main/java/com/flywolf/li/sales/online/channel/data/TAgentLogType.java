package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "T_AGENT_LOG_TYPE")
@EqualsAndHashCode(callSuper = true)
public class TAgentLogType extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LOG_TYPE
     */
    @Id
    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    /**
     * TYPE_DESC
     */
    @Column(name = "TYPE_DESC", nullable = false)
    private String typeDesc;

}
