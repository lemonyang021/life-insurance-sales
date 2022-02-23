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
@Table(name = "T_AGENT_FORBID_PRODUCT_LOG")
public class TAgentForbidProductLog extends ExtendableAuditEntity implements Serializable {

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
     * SALES_CHG_ID
     */
    @Column(name = "SALES_CHG_ID", nullable = false)
    private String salesChgId;

    /**
     * LAST_CMT_FLG
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * FORBID_ID
     */
    @Column(name = "FORBID_ID", nullable = false)
    private String forbidId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * PRODUCT_ID
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

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

}
