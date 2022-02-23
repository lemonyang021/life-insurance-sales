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
 * Data table for special agent information log
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_SPECIAL_INFO_LOG")
public class TAgentSpecialInfoLog extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LOG SEQUENCE
     */
    @Id
    @Column(name = "LOG_ID", nullable = false)
    private String logId;

    /**
     * TYPE OF LOG
     */
    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    /**
     * APPLICATION ID
     */
    @Column(name = "CHANGE_ID", nullable = false)
    private String changeId;

    /**
     * POLICY/PARTY/SALES ALTERATION ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

    /**
     * LAST COMMIT FLAG
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * INFO ID
     */
    @Column(name = "INFO_ID")
    private String infoId;

    /**
     * AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * IC INDICATOR
     */
    @Column(name = "IC_INDI", nullable = false)
    private String icIndi;

    /**
     * LIMIT AMOUNT
     */
    @Column(name = "LIMIT_AMOUNT", nullable = false)
    private String limitAmount;

    /**
     * RECORD CREATOR
     */
    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    /**
     * LATEST MODIFIER
     */
    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

}
