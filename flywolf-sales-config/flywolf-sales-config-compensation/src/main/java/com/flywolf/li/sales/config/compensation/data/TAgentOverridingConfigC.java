package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_OVERRIDING_CONFIG_C")
public class TAgentOverridingConfigC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "LOG_ID", nullable = false)
    private String logId;

    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    @Column(name = "CHANGE_ID", nullable = false)
    private String changeId;

    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    @Column(name = "CONFIG_ID")
    private String configId;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "START_MONTH", nullable = false)
    private String startMonth;

    @Column(name = "END_MONTH", nullable = false)
    private String endMonth;

    @Column(name = "OVERRIDING_RATE", nullable = false)
    private String overridingRate;

    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

}
