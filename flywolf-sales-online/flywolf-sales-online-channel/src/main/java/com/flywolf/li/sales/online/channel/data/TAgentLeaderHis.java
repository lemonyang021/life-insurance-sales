package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_AGENT_LEADER_HIS")
@EqualsAndHashCode(callSuper = true)
public class TAgentLeaderHis extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_HIS_ID
     */
    @Id
    @Column(name = "AGENT_HIS_ID", nullable = false)
    private String agentHisId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * START_DATE
     */
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    /**
     * END_DATE
     */
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    /**
     * PRINCIPAL_ID
     */
    @Column(name = "PRINCIPAL_ID", nullable = false)
    private String principalId;

    /**
     * PRINCIPAL_GRADE
     */
    @Column(name = "PRINCIPAL_GRADE", nullable = false)
    private String principalGrade;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID")
    private String deptId;

}
