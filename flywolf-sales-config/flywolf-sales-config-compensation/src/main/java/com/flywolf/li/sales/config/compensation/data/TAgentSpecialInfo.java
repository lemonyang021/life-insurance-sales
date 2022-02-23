package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Data table for special agent information
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_SPECIAL_INFO")
public class TAgentSpecialInfo extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * INFO ID
     */
    @Id
    @Column(name = "INFO_ID", nullable = false)
    private String infoId;

    /**
     * AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * IC INDICATOR
     */
    @Column(name = "IC_INDI", nullable = false)
    private String icIndi;

    /**
     * LIMIT AMOUNT
     */
    @Column(name = "LIMIT_AMOUNT", nullable = false)
    private String limitAmount;

    /**
     * RECORD CREATOR
     */
    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    /**
     * LATEST MODIFIER
     */
    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

}
