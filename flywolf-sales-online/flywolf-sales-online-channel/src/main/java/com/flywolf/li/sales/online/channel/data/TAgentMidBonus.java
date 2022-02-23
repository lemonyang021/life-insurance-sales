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

@Data
@Entity
@Table(name = "T_AGENT_MID_BONUS")
@EqualsAndHashCode(callSuper = true)
public class TAgentMidBonus extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201903][IFA Mid Month Payment]BONUS_ID
     */
    @Id
    @Column(name = "BONUS_ID", nullable = false)
    private String bonusId;

    /**
     * [201903][IFA Mid Month Payment]AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201903][IFA Mid Month Payment]DEPT_ID
     */
    @Column(name = "DEPT_ID", nullable = false)
    private String deptId;

    /**
     * [201903][IFA Mid Month Payment]BONUS_TYPE
     */
    @Column(name = "BONUS_TYPE", nullable = false)
    private String bonusType;

    /**
     * [201903][IFA Mid Month Payment]COMMISION_ID
     */
    @Column(name = "COMMISION_ID")
    private String commisionId;

    /**
     * [201903][IFA Mid Month Payment]DUE_DATE
     */
    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    /**
     * [201903][IFA Mid Month Payment]BONUS_AMOUNT
     */
    @Column(name = "BONUS_AMOUNT", nullable = false)
    private String bonusAmount;

    /**
     * [201903][IFA Mid Month Payment]CURRENCY_ID
     */
    @Column(name = "CURRENCY_ID", nullable = false)
    private String currencyId;

    /**
     * [201903][IFA Mid Month Payment]RECORDER_ID
     */
    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    /**
     * [201903][IFA Mid Month Payment]UPDATER_ID
     */
    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

    /**
     * [201903][IFA Mid Month Payment]COMM_STATUS
     */
    @Column(name = "COMM_STATUS", nullable = false)
    private String commStatus;

    /**
     * [201903][IFA Mid Month Payment]CUR_YR_P_FYC
     */
    @Column(name = "CUR_YR_P_FYC")
    private String curYrPFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_P_FYC
     */
    @Column(name = "CUR_MON_P_FYC")
    private String curMonPFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_U_FYC
     */
    @Column(name = "CUR_MON_U_FYC")
    private String curMonUFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_RT_FYC
     */
    @Column(name = "CUR_MON_RT_FYC")
    private String curMonRtFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_1U_FYC
     */
    @Column(name = "CUR_MON_1U_FYC")
    private String curMon1uFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_2U_FYC
     */
    @Column(name = "CUR_MON_2U_FYC")
    private String curMon2uFyc;

    /**
     * [201903][IFA Mid Month Payment]PRE_YR_P_FYC
     */
    @Column(name = "PRE_YR_P_FYC")
    private String preYrPFyc;

    /**
     * [201903][IFA Mid Month Payment]PRE_YR_P_RYC
     */
    @Column(name = "PRE_YR_P_RYC")
    private String preYrPRyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_P_PR
     */
    @Column(name = "CUR_MON_P_PR")
    private String curMonPPr;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_U_PR
     */
    @Column(name = "CUR_MON_U_PR")
    private String curMonUPr;

    /**
     * [201903][IFA Mid Month Payment]CUR_YR_P_PR
     */
    @Column(name = "CUR_YR_P_PR")
    private String curYrPPr;

    /**
     * [201903][IFA Mid Month Payment]SERVICE_PERIOD
     */
    @Column(name = "SERVICE_PERIOD")
    private String servicePeriod;

    /**
     * [201903][IFA Mid Month Payment]AGENT_GRADE
     */
    @Column(name = "AGENT_GRADE")
    private String agentGrade;

    /**
     * [201903][IFA Mid Month Payment]PAYER_ID
     */
    @Column(name = "PAYER_ID")
    private String payerId;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_P_RYC
     */
    @Column(name = "CUR_MON_P_RYC")
    private String curMonPRyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_DL_RM_FYC
     */
    @Column(name = "CUR_MON_DL_RM_FYC")
    private String curMonDlRmFyc;

    /**
     * [201903][IFA Mid Month Payment]CUR_MON_DL_FYC
     */
    @Column(name = "CUR_MON_DL_FYC")
    private String curMonDlFyc;

    /**
     * [201903][IFA Mid Month Payment]QTD_AFYC
     */
    @Column(name = "QTD_AFYC")
    private String qtdAfyc;

    /**
     * [201903][IFA Mid Month Payment]QYD_FYC
     */
    @Column(name = "QYD_FYC")
    private String qydFyc;

    /**
     * [201903][IFA Mid Month Payment]OWN_GB
     */
    @Column(name = "OWN_GB")
    private String ownGb;

    /**
     * [201903][IFA Mid Month Payment]DL_GB
     */
    @Column(name = "DL_GB")
    private String dlGb;

    /**
     * [201903][IFA Mid Month Payment]ADD_DL_BONUS
     */
    @Column(name = "ADD_DL_BONUS")
    private String addDlBonus;

    /**
     * [201903][IFA Mid Month Payment]ADD_REDUCE_ID of T_ADD_REDUCE_MONEY
     */
    @Column(name = "ADD_REDUCE_ID")
    private String addReduceId;

    /**
     * [201903][IFA Mid Month Payment]COMMISSION_ITEM_ID of T_PRODUCT_COMMISION
     */
    @Column(name = "COMMISION_ITEM_ID")
    private String commisionItemId;

    /**
     * [201903][IFA Mid Month Payment]BONUS_RATE
     */
    @Column(name = "BONUS_RATE")
    private String bonusRate;

    /**
     * [201903][IFA Mid Month Payment]MOR/SMOM/SMOQ/SMO3
     */
    @Column(name = "SUB_BONUS_TYPE")
    private String subBonusType;

    /**
     * [201903][IFA Mid Month Payment]Personal FYC
     */
    @Column(name = "GB_PERSONAL_FYC")
    private String gbPersonalFyc;

    /**
     * [201903][IFA Mid Month Payment]GB_RATE
     */
    @Column(name = "GB_RATE")
    private String gbRate;

    /**
     * [201903][IFA Mid Month Payment]contribution agent
     */
    @Column(name = "GB_AGENT_ID")
    private String gbAgentId;

    /**
     * [201903][IFA Mid Month Payment]Identifier Of ILP
     */
    @Column(name = "ILP_INDI")
    private String ilpIndi;

    /**
     * [201903][IFA Mid Month Payment]Identifier Of adjustment type
     */
    @Column(name = "REMARK")
    private String REMARK;

    /**
     * [201903][IFA Mid Month Payment]Current Manager’s Override
     */
    @Column(name = "CUR_MO")
    private String curMo;

}
