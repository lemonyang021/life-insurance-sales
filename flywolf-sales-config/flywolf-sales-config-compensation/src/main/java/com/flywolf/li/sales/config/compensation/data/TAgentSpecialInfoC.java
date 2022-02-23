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
@Table(name = "T_AGENT_SPECIAL_INFO_C")
public class TAgentSpecialInfoC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "INFO_ID")
    private String infoId;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "IC_INDI", nullable = false)
    private String icIndi;

    @Column(name = "LIMIT_AMOUNT", nullable = false)
    private String limitAmount;

    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

}
