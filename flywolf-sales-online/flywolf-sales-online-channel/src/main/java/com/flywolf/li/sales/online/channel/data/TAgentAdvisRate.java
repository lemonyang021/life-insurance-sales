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
@Table(name = "T_AGENT_ADVIS_RATE")
@EqualsAndHashCode(callSuper = true)
public class TAgentAdvisRate extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CONFIG ID
     */
    @Id
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * ADVIS RATE
     */
    @Column(name = "ADVIS_RATE", nullable = false)
    private String advisRate;

}
