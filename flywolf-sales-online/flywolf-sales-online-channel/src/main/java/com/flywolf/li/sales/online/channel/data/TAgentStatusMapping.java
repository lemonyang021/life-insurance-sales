package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * [201801][CM-666] agent status mapping
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_STATUS_MAPPING")
public class TAgentStatusMapping extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201801][CM-666] status reason
     */
    @Id
    @Column(name = "STATUS_REASON", nullable = false)
    private String statusReason;

    /**
     * [201801][CM-666] clause id
     */
    @Id
    @Column(name = "CLAUSE_ID", nullable = false)
    private String clauseId;

}
