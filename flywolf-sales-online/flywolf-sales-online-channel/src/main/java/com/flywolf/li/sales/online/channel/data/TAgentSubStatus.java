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
@Table(name = "T_AGENT_SUB_STATUS")
@EqualsAndHashCode(callSuper = true)
public class TAgentSubStatus extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * STATUS_CODE
     */
    @Column(name = "STATUS_CODE")
    private String statusCode;

    /**
     * STATUS_DESC
     */
    @Column(name = "STATUS_DESC")
    private String statusDesc;

    /**
     * STATUS_ID
     */
    @Id
    @Column(name = "STATUS_ID", nullable = false)
    private String statusId;

}
