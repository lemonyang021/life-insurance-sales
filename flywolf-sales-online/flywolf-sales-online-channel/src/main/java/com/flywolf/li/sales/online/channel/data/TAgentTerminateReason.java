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
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_TERMINATE_REASON")
public class TAgentTerminateReason extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * TERMINATE_REASON
     */
    @Id
    @Column(name = "TERMINATE_REASON", nullable = false)
    private String terminateReason;

    /**
     * REASON_DESC
     */
    @Column(name = "REASON_DESC", nullable = false)
    private String reasonDesc;

}
