package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Data table to store the detail records of bonus for agent
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_BONUS_FEE_DETAIL")
public class TAgentBonusFeeDetail extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * DETAIL_ID
     */
    @Id
    @Column(name = "DETAIL_ID", nullable = false)
    private String detailId;

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
     * POLICY_ID
     */
    @Column(name = "POLICY_ID")
    private String policyId;

    /**
     * ITEM_ID
     */
    @Column(name = "ITEM_ID")
    private String itemId;

    /**
     * PRODUCT_ID
     */
    @Column(name = "PRODUCT_ID")
    private String productId;

    /**
     * FUND_CODE
     */
    @Column(name = "FUND_CODE")
    private String fundCode;

    /**
     * DUE_DATE
     */
    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    /**
     * YEAR_MONTH
     */
    @Column(name = "YEAR_MONTH", nullable = false)
    private String yearMonth;

    /**
     * CURRENCY_AMT
     */
    @Column(name = "CURRENCY_AMT")
    private String currencyAmt;

    /**
     * BASE_AMT
     */
    @Column(name = "BASE_AMT")
    private String baseAmt;

    /**
     * FEE_RATE
     */
    @Column(name = "FEE_RATE")
    private String feeRate;

    /**
     * FEE_AMT
     */
    @Column(name = "FEE_AMT")
    private String feeAmt;

    /**
     * EXCHANGE_RATE
     */
    @Column(name = "EXCHANGE_RATE")
    private String exchangeRate;

    /**
     * ASSIGN_RATE
     */
    @Column(name = "ASSIGN_RATE")
    private String assignRate;

    /**
     * BONUS_ID
     */
    @Column(name = "BONUS_ID")
    private String bonusId;

    /**
     * POLICY_CHANGE_ID
     */
    @Column(name = "POLICY_CHANGE_ID")
    private String policyChangeId;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee For Basic Account
     */
    @Column(name = "BASIC_AMOUNT")
    private String basicAmount;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee Rate For Basic Account
     */
    @Column(name = "BASIC_RATE")
    private String basicRate;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee For Holding  Account
     */
    @Column(name = "HOLD_AMOUNT")
    private String holdAmount;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee Rate For Holding  Account
     */
    @Column(name = "HOLD_RATE")
    private String holdRate;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee For TOP Account
     */
    @Column(name = "TOP_AMOUNT")
    private String topAmount;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee Rate For TOP Amount
     */
    @Column(name = "TOP_RATE")
    private String topRate;

    /**
     * [201510][Compensation Enhancement for ILP]Trailer Fee Payment Frequency
     */
    @Column(name = "PAY_FREQUENCY")
    private String payFrequency;

    /**
     * [201510][Compensation Enhancement for ILP]Identifier Of ILP
     */
    @Column(name = "ILP_INDI")
    private String ilpIndi;

    /**
     * [201510][Compensation Enhancement for ILP]Holiday Indicator
     */
    @Column(name = "HOLIDAY_INDI")
    private String holidayIndi;

    /**
     * [201607][CA]IR DETAIL ID
     */
    @Column(name = "IR_DETAIL_ID")
    private String irDetailId;

    /**
     * [201804][IFA Excess FYC Paid in 2nd Year] benefit id
     */
    @Column(name = "BENEFIT_ID")
    private String benefitId;

    /**
     * [201807][IFA Override Rates by PPP]Rate tier id
     */
    @Column(name = "RATE_TIER")
    private String rateTier;

}
