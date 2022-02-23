package com.flywolf.li.sales.config.compensation.data;

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
@Table(name = "T_AGENT_GRADE_HIS")
@EqualsAndHashCode(callSuper = true)
public class TAgentGradeHis extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * GRADE_HIS_ID
     */
    @Id
    @Column(name = "GRADE_HIS_ID", nullable = false)
    private String gradeHisId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * AGENT_GRADE
     */
    @Column(name = "AGENT_GRADE", nullable = false)
    private String agentGrade;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID", nullable = false)
    private String deptId;

    /**
     * PRINCIPAL_ID
     */
    @Column(name = "PRINCIPAL_ID", nullable = false)
    private String principalId;

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
     * SALES_CHG_ID
     */
    @Column(name = "SALES_CHG_ID", nullable = false)
    private String salesChgId;

}
