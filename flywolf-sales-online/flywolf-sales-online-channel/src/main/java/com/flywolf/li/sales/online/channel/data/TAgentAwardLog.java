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
@Table(name = "T_AGENT_AWARD_LOG")
@EqualsAndHashCode(callSuper = true)
public class TAgentAwardLog extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LOG_ID
     */
    @Id
    @Column(name = "LOG_ID", nullable = false)
    private String logId;

    /**
     * LOG_TYPE
     */
    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    /**
     * CHANGE_ID
     */
    @Column(name = "CHANGE_ID", nullable = false)
    private String changeId;

    /**
     * LAST_CMT_FLG
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * AWARD_ID
     */
    @Column(name = "AWARD_ID", nullable = false)
    private String awardId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * AWARD_TYPE
     */
    @Column(name = "AWARD_TYPE", nullable = false)
    private String awardType;

    /**
     * AWARD_CLASS
     */
    @Column(name = "AWARD_CLASS")
    private String awardClass;

    /**
     * AWARD_YEAR
     */
    @Column(name = "AWARD_YEAR")
    private String awardYear;

    /**
     * EFFECTIVE_DATE
     */
    @Column(name = "EFFECTIVE_DATE")
    private LocalDate effectiveDate;

    /**
     * EXPIRE_DATE
     */
    @Column(name = "EXPIRE_DATE")
    private LocalDate expireDate;

    /**
     * AWARD_ITEM
     */
    @Column(name = "AWARD_ITEM", nullable = false)
    private String awardItem;

    /**
     * SALES_CHG_ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

}
