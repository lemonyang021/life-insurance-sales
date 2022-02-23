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
 * [201510][Compensation for ILP]Agent Bonus RYC  Overriding Detail for policy level
 */
@Data
@Entity
@Table(name = "T_AGENT_BONUS_RO")
@EqualsAndHashCode(callSuper = true)
public class TAgentBonusRo extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201510][Compensation for ILP]PK
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * [201510][Compensation for ILP]Agent ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201510][Compensation for ILP]Policy ID
     */
    @Column(name = "POLICY_ID")
    private String policyId;

    /**
     * [201510][Compensation for ILP]Down line Agent ID
     */
    @Column(name = "DOWN_AGENT_ID", nullable = false)
    private String downAgentId;

    /**
     * [201510][Compensation for ILP]Commission Bonus Type
     */
    @Column(name = "BONUS_TYPE")
    private String bonusType;

    /**
     * [201510][Compensation for ILP]Overriding Type
     */
    @Column(name = "OR_TYPE")
    private String orType;

    /**
     * [201510][Compensation for ILP]RYC  Production
     */
    @Column(name = "RYC_COMM")
    private String rycComm;

    /**
     * [201510][Compensation for ILP]RYC Rate
     */
    @Column(name = "RYC_RATE")
    private String rycRate;

    /**
     * [201510][Compensation for ILP]RYC  Overriding
     */
    @Column(name = "RYC_OR")
    private String rycOr;

    /**
     * [201510][Compensation for ILP]Commession Calulation  Month
     */
    @Column(name = "COMM_MONTH")
    private String commMonth;

    /**
     * [201510][Compensation for ILP]T_agent_bonus  Detail ID
     */
    @Column(name = "DETAIL_ID")
    private String detailId;

    /**
     * [201510][Compensation for ILP]Agent Grade Rate For OR
     */
    @Column(name = "GRADE_RATE")
    private String gradeRate;

    /**
     * [201510][Compensation for ILP]Due Date
     */
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    /**
     * [201510][Compensation for ILP]product id
     */
    @Column(name = "PRODUCT_ID")
    private String productId;

}
