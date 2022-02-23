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
@Table(name = "T_AGENT_OLD_JOB")
@EqualsAndHashCode(callSuper = true)
public class TAgentOldJob extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * OLD_JOB_ID
     */
    @Id
    @Column(name = "OLD_JOB_ID", nullable = false)
    private String oldJobId;

    /**
     * JOB_DESC
     */
    @Column(name = "JOB_DESC", nullable = false)
    private String jobDesc;

}
