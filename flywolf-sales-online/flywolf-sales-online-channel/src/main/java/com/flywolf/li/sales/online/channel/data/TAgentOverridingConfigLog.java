package com.flywolf.li.sales.online.channel.data;

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
@Table(name = "T_AGENT_OVERRIDING_CONFIG_LOG")
public class TAgentOverridingConfigLog extends ExtendableAuditEntity implements Serializable {

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
     * SALES ALTERATION ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

    /**
     * LAST COMMIT FLAG
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * CONFIG ID
     */
    @Column(name = "CONFIG_ID")
    private String configId;

    /**
     * AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * PRODUCT ID
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    /**
     * START MONTH
     */
    @Column(name = "START_MONTH", nullable = false)
    private String startMonth;

    /**
     * END MONTH
     */
    @Column(name = "END_MONTH", nullable = false)
    private String endMonth;

    /**
     * OVERRIDING RATE
     */
    @Column(name = "OVERRIDING_RATE", nullable = false)
    private String overridingRate;

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
