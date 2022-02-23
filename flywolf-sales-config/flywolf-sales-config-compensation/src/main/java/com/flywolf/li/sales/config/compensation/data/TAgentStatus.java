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
@Table(name = "T_AGENT_STATUS")
@EqualsAndHashCode(callSuper = true)
public class TAgentStatus extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_STATUS
     */
    @Id
    @Column(name = "AGENT_STATUS", nullable = false)
    private String agentStatus;

    /**
     * AGENT_STATUS_NAME
     */
    @Column(name = "AGENT_STATUS_NAME")
    private String agentStatusName;

}
