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
 * T_AGENT_COM_OVERRIDE
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_COM_OVERRIDE")
public class TAgentComOverride extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CONFIG_ID
     */
    @Id
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * COMMISSION_TYPE_ID
     */
    @Column(name = "COMMISION_TYPE_ID", nullable = false)
    private String commisionTypeId;

    /**
     * START_MONTH
     */
    @Column(name = "START_MONTH", nullable = false)
    private String startMonth;

    /**
     * END_MONTH
     */
    @Column(name = "END_MONTH", nullable = false)
    private String endMonth;

    /**
     * OVERRIDE_RATE
     */
    @Column(name = "OVERRIDE_RATE", nullable = false)
    private String overrideRate;

    /**
     * PRODUCT_ID
     */
    @Column(name = "PRODUCT_ID")
    private String productId;

    /**
     * [201604][compensation for ILP]POLICY YEAR START
     */
    @Column(name = "POLICY_YEAR_START")
    private String policyYearStart;

    /**
     * [201604][compensation for ILP]POLICY YEAR END
     */
    @Column(name = "POLICY_YEAR_END")
    private String policyYearEnd;

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
