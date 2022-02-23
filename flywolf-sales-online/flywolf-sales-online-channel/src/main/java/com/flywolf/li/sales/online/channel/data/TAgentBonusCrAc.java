package com.flywolf.li.sales.online.channel.data;

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
 * test table for CR AC, same with T_AGENT_BONUS
 */
@Data
@Entity
@Table(name = "T_AGENT_BONUS_CR_AC")
@EqualsAndHashCode(callSuper = true)
public class TAgentBonusCrAc extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * BONUS_ID
     */
    @Id
    @Column(name = "BONUS_ID", nullable = false)
    private String bonusId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID", nullable = false)
    private String deptId;

    /**
     * BONUS_TYPE
     */
    @Column(name = "BONUS_TYPE", nullable = false)
    private String bonusType;

    /**
     * COMMISION_ID
     */
    @Column(name = "COMMISION_ID")
    private String commisionId;

    /**
     * DUE_DATE
     */
    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    /**
     * BONUS_AMOUNT
     */
    @Column(name = "BONUS_AMOUNT", nullable = false)
    private String bonusAmount;

    /**
     * CURRENCY_ID
     */
    @Column(name = "CURRENCY_ID", nullable = false)
    private String currencyId;

    /**
     * RECORDER_ID
     */
    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    /**
     * UPDATER_ID
     */
    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

    /**
     * COMM_STATUS
     */
    @Column(name = "COMM_STATUS", nullable = false)
    private String commStatus;

    /**
     * CUR_YR_P_FYC
     */
    @Column(name = "CUR_YR_P_FYC")
    private String curYrPFyc;

    /**
     * CUR_MON_P_FYC
     */
    @Column(name = "CUR_MON_P_FYC")
    private String curMonPFyc;

    /**
     * CUR_MON_U_FYC
     */
    @Column(name = "CUR_MON_U_FYC")
    private String curMonUFyc;

    /**
     * CUR_MON_RT_FYC
     */
    @Column(name = "CUR_MON_RT_FYC")
    private String curMonRtFyc;

    /**
     * CUR_MON_1U_FYC
     */
    @Column(name = "CUR_MON_1U_FYC")
    private String curMon1uFyc;

    /**
     * CUR_MON_2U_FYC
     */
    @Column(name = "CUR_MON_2U_FYC")
    private String curMon2uFyc;

    /**
     * PRE_YR_P_FYC
     */
    @Column(name = "PRE_YR_P_FYC")
    private String preYrPFyc;

    /**
     * PRE_YR_P_RYC
     */
    @Column(name = "PRE_YR_P_RYC")
    private String preYrPRyc;

    /**
     * CUR_MON_P_PR
     */
    @Column(name = "CUR_MON_P_PR")
    private String curMonPPr;

    /**
     * CUR_MON_U_PR
     */
    @Column(name = "CUR_MON_U_PR")
    private String curMonUPr;

    /**
     * CUR_YR_P_PR
     */
    @Column(name = "CUR_YR_P_PR")
    private String curYrPPr;

    /**
     * SERVICE_PERIOD
     */
    @Column(name = "SERVICE_PERIOD")
    private String servicePeriod;

    /**
     * AGENT_GRADE
     */
    @Column(name = "AGENT_GRADE")
    private String agentGrade;

    /**
     * PAYER_ID
     */
    @Column(name = "PAYER_ID")
    private String payerId;

    /**
     * CUR_MON_P_RYC
     */
    @Column(name = "CUR_MON_P_RYC")
    private String curMonPRyc;

    /**
     * CUR_MON_DL_RM_FYC
     */
    @Column(name = "CUR_MON_DL_RM_FYC")
    private String curMonDlRmFyc;

    /**
     * CUR_MON_DL_FYC
     */
    @Column(name = "CUR_MON_DL_FYC")
    private String curMonDlFyc;

    /**
     * QTD_AFYC
     */
    @Column(name = "QTD_AFYC")
    private String qtdAfyc;

    /**
     * QYD_FYC
     */
    @Column(name = "QYD_FYC")
    private String qydFyc;

    /**
     * OWN_GB
     */
    @Column(name = "OWN_GB")
    private String ownGb;

    /**
     * DL_GB
     */
    @Column(name = "DL_GB")
    private String dlGb;

    /**
     * ADD_DL_BONUS
     */
    @Column(name = "ADD_DL_BONUS")
    private String addDlBonus;

    /**
     * ADD_REDUCE_ID of T_ADD_REDUCE_MONEY
     */
    @Column(name = "ADD_REDUCE_ID")
    private String addReduceId;

    /**
     * COMMISSION_ITEM_ID of T_PRODUCT_COMMISION
     */
    @Column(name = "COMMISION_ITEM_ID")
    private String commisionItemId;

    /**
     * BONUS_RATE
     */
    @Column(name = "BONUS_RATE")
    private String bonusRate;

    /**
     * MOR/SMOM/SMOQ/SMO3
     */
    @Column(name = "SUB_BONUS_TYPE")
    private String subBonusType;

    /**
     * Personal FYC
     */
    @Column(name = "GB_PERSONAL_FYC")
    private String gbPersonalFyc;

    /**
     * GB_RATE
     */
    @Column(name = "GB_RATE")
    private String gbRate;

    /**
     * GB_AGENT_ID
     */
    @Column(name = "GB_AGENT_ID")
    private String gbAgentId;

}
