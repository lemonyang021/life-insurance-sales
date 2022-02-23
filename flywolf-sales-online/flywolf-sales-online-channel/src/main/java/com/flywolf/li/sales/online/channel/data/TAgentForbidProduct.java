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
@Table(name = "T_AGENT_FORBID_PRODUCT")
public class TAgentForbidProduct extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * FORBID_ID
     */
    @Id
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

    /**
     * status
     */
    @Column(name = "STATUS", nullable = false)
    private String STATUS;

}
