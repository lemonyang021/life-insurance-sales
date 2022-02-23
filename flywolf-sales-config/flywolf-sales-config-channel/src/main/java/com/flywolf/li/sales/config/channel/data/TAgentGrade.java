package com.flywolf.li.sales.config.channel.data;

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
@Table(name = "T_AGENT_GRADE")
@EqualsAndHashCode(callSuper = true)
public class TAgentGrade extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_GRADE
     */
    @Id
    @Column(name = "AGENT_GRADE", nullable = false)
    private String agentGrade;

    /**
     * GRADE_NAME
     */
    @Column(name = "GRADE_NAME", nullable = false)
    private String gradeName;

    /**
     * DEPT_LEVEL
     */
    @Column(name = "DEPT_LEVEL")
    private String deptLevel;

    /**
     * CAN_BE_LEADER
     */
    @Column(name = "CAN_BE_LEADER")
    private String canBeLeader;

    /**
     * GRADE_ORDER
     */
    @Column(name = "GRADE_ORDER")
    private String gradeOrder;

    /**
     * AGENT_CATE
     */
    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

    /**
     * RECRUIT_INDI
     */
    @Column(name = "RECRUIT_INDI", nullable = false)
    private String recruitIndi;

    /**
     * GRADE_RANK
     */
    @Column(name = "GRADE_RANK", nullable = false)
    private String gradeRank;

    /**
     * FYC_LIMIT
     */
    @Column(name = "FYC_LIMIT")
    private String fycLimit;

    /**
     * GRADE_CODE
     */
    @Column(name = "GRADE_CODE", nullable = false)
    private String gradeCode;

    /**
     * IS_VALID
     */
    @Column(name = "IS_VALID", nullable = false)
    private String valid;

    /**
     * MASTER_ID
     */
    @Column(name = "MASTER_ID")
    private String masterId;

}
