package com.flywolf.li.sales.config.compensation.data;

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
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_STATUS_REASON")
public class TAgentStatusReason extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * STATUS_REASON
     */
    @Id
    @Column(name = "STATUS_REASON", nullable = false)
    private String statusReason;

    /**
     * REASON_DESC
     */
    @Column(name = "REASON_DESC", nullable = false)
    private String reasonDesc;

}
