package com.flywolf.li.sales.online.channel.data;

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
@Table(name = "T_AGENT_TERMINATE_MAPPING")
public class TAgentTerminateMapping extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "STATUS_REASON")
    private String statusReason;

    @Column(name = "TERMINATE_CLAUSE")
    private String terminateClause;

}
