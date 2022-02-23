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
@Table(name = "T_AGENT_FORBID_PRODUCT_BAK")
public class TAgentForbidProductBak extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LOG ID
     */
    @Id
    @Column(name = "BAK_ID", nullable = false)
    private String bakId;

    /**
     * FORBID ID
     */
    @Column(name = "FORBID_ID", nullable = false)
    private String forbidId;

    /**
     * AGENT ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

}
