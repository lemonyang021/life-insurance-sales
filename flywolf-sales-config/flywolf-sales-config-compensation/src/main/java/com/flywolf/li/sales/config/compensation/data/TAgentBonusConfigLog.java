package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_BONUS_CONFIG_LOG")
public class TAgentBonusConfigLog extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CONFIG_ID
     */
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * COMMISION_TYPE
     */
    @Column(name = "COMMISION_TYPE", nullable = false)
    private String commisionType;

    /**
     * ELIGIBLE_INDI
     */
    @Column(name = "ELIGIBLE_INDI", nullable = false)
    private String eligibleIndi;

    /**
     * ELIGIBLE_AMOUNT
     */
    @Column(name = "ELIGIBLE_AMOUNT", nullable = false)
    private String eligibleAmount;

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
     * BONUS_PERIOD
     */
    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

    /**
     * SALES_CHG_ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

}
