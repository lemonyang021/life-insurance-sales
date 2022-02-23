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
 * [201607][CA]config table for agent bonus rate.
 */
@Data
@Entity
@Table(name = "T_AGENT_BONUS_RATE")
@EqualsAndHashCode(callSuper = true)
public class TAgentBonusRate extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201607][CA]PK RATE ID
     */
    @Id
    @Column(name = "RATE_ID", nullable = false)
    private String rateId;

    /**
     * [201607][CA]AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201607][CA]PRODUCT ID
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    /**
     * [201607][CA]BONUS TYPE
     */
    @Column(name = "BONUS_TYPE", nullable = false)
    private String bonusType;

    /**
     * [201607][CA]START MONTH
     */
    @Column(name = "START_MONTH", nullable = false)
    private String startMonth;

    /**
     * [201607][CA]END MONTH
     */
    @Column(name = "END_MONTH", nullable = false)
    private String endMonth;

    /**
     * [201607][CA]COMMISSION START YEAR
     */
    @Column(name = "COMMISSION_START_YEAR", nullable = false)
    private String commissionStartYear;

    /**
     * [201607][CA]COMMISSION END YEAR
     */
    @Column(name = "COMMISSION_END_YEAR", nullable = false)
    private String commissionEndYear;

    /**
     * [201607][CA]BONUS RATE
     */
    @Column(name = "BONUS_RATE", nullable = false)
    private String bonusRate;

    /**
     * [201607][CA]LATEST MODIFIER
     */
    @Column(name = "UPDATER_ID")
    private String updaterId;

    /**
     * [201807][IFA Override Rates by PPP]Policy premium year
     */
    @Column(name = "CHARGE_YEAR")
    private String chargeYear;

    /**
     * [202101][CM-795] issue afyp
     */
    @Column(name = "ISSUE_AFYP")
    private String issueAfyp;

}
