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
@Table(name = "T_AGENT_WELFARE_STATUS")
public class TAgentWelfareStatus extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * WELFARE_STATUS
     */
    @Id
    @Column(name = "WELFARE_STATUS", nullable = false)
    private String welfareStatus;

    /**
     * STATUS_DESC
     */
    @Column(name = "STATUS_DESC", nullable = false)
    private String statusDesc;

}
