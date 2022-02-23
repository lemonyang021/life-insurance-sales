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
@Table(name = "T_AGENT_OVERRIDING_CONFIG")
public class TAgentOverridingConfig extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CONFIG ID
     */
    @Id
    @Column(name = "CONFIG_ID", nullable = false)
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

    /**
     * COMM_TYPE
     */
    @Column(name = "COMM_TYPE")
    private String commType;

}
