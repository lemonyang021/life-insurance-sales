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
 * [201812][Bonus Enhancement Phase2]config table for agent bonus rate.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_BONUS_RATE_CONFIG")
public class TAgentBonusRateConfig extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201812][Bonus Enhancement Phase2]pk rate id
     */
    @Id
    @Column(name = "RATE_ID", nullable = false)
    private String rateId;

    /**
     * [201812][Bonus Enhancement Phase2]agent id
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201812][Bonus Enhancement Phase2]calc month
     */
    @Column(name = "CALC_MONTH")
    private String calcMonth;

    /**
     * [201812][Bonus Enhancement Phase2]bonus type
     */
    @Column(name = "BONUS_TYPE")
    private String bonusType;

    /**
     * [201812][Bonus Enhancement Phase2]rate count
     */
    @Column(name = "RATE_COUNT")
    private String rateCount;

}
