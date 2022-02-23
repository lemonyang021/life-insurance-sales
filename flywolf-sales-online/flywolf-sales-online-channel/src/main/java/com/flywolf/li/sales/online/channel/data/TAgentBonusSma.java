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
 * Data table to store the detail records of bonus SMA for agent
 */
@Data
@Entity
@Table(name = "T_AGENT_BONUS_SMA")
@EqualsAndHashCode(callSuper = true)
public class TAgentBonusSma extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PK list_id
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * Agent ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * commission tpe id
     */
    @Column(name = "COMMISION_TYPE_ID", nullable = false)
    private String commisionTypeId;

    /**
     * comm cycle month
     */
    @Column(name = "YEAR_MONTH", nullable = false)
    private String yearMonth;

    /**
     * Average agent monthly target for SMA
     */
    @Column(name = "TARGET")
    private String TARGET;

    /**
     * After percentage agent monthly target for SMA
     */
    @Column(name = "PER_TARGET")
    private String perTarget;

    /**
     * current mohth agent adjustment target for SMA
     */
    @Column(name = "TARGET_ADJ")
    private String targetAdj;

    /**
     * Actual value in current month
     */
    @Column(name = "ACR_VALUE")
    private String acrValue;

    /**
     * Actual value and target percentage
     */
    @Column(name = "ACR_PER_RATE")
    private String acrPerRate;

    /**
     * current month persistency rate for agent
     */
    @Column(name = "CUR_MON_PR")
    private String curMonPr;

    /**
     * calculation bonus amount with actual persistency rate amount
     */
    @Column(name = "CUR_PER_RATE")
    private String curPerRate;

    /**
     * current agnent current grade start date
     */
    @Column(name = "GRADE_START_DATE")
    private LocalDate gradeStartDate;

    /**
     * carch up indi  ,not catch up is N  quterly catchup is Q yearly catch up is Y
     */
    @Column(name = "CATCH_UP_INDI")
    private String catchUpIndi;

    /**
     * actual catch up amount
     */
    @Column(name = "CARCH_UP_AMOUNT")
    private String carchUpAmount;

    /**
     * calucation bonus basic amount
     */
    @Column(name = "CAL_BASE_AMOUNT")
    private String calBaseAmount;

    /**
     * calucation bonus amount
     */
    @Column(name = "BONUS_AMOUNT")
    private String bonusAmount;

}
