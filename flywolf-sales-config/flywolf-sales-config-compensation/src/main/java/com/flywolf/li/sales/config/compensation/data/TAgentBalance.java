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
@Table(name = "T_AGENT_BALANCE")
@EqualsAndHashCode(callSuper = true)
public class TAgentBalance extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_ID
     */
    @Id
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * POLICY_TYPE
     */
    @Id
    @Column(name = "POLICY_TYPE", nullable = false)
    private String policyType;

    /**
     * PAY_BALANCE
     */
    @Column(name = "PAY_BALANCE", nullable = false)
    private String payBalance;

}
