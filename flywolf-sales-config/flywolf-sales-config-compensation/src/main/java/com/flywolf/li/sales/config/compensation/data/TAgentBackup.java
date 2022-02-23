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
@Table(name = "T_AGENT_BACKUP")
@EqualsAndHashCode(callSuper = true)
public class TAgentBackup extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LIST_ID
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * YEAR_MONTH
     */
    @Column(name = "YEAR_MONTH", nullable = false)
    private String yearMonth;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * AGENT_CODE
     */
    @Column(name = "AGENT_CODE", nullable = false)
    private String agentCode;

    /**
     * ORGAN_ID
     */
    @Column(name = "ORGAN_ID", nullable = false)
    private String organId;

    /**
     * HEAD_ID
     */
    @Column(name = "HEAD_ID", nullable = false)
    private String headId;

    /**
     * BRANCH_ID
     */
    @Column(name = "BRANCH_ID", nullable = false)
    private String branchId;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID", nullable = false)
    private String deptId;

    /**
     * TRAIN_MAN_ID
     */
    @Column(name = "TRAIN_MAN_ID")
    private String trainManId;

    /**
     * RECOMMEND_MAN_ID
     */
    @Column(name = "RECOMMEND_MAN_ID")
    private String recommendManId;

    /**
     * GRADE_ID
     */
    @Column(name = "GRADE_ID")
    private String gradeId;

    /**
     * ENTER_COMPANY_DATE
     */
    @Column(name = "ENTER_COMPANY_DATE")
    private LocalDate enterCompanyDate;

    /**
     * LEAVE_COMPANY_DATE
     */
    @Column(name = "LEAVE_COMPANY_DATE")
    private LocalDate leaveCompanyDate;

    /**
     * AGENT_STATUS
     */
    @Column(name = "AGENT_STATUS", nullable = false)
    private String agentStatus;

    /**
     * PROBATION_DATE
     */
    @Column(name = "PROBATION_DATE")
    private LocalDate probationDate;

    /**
     * TURN_DATE
     */
    @Column(name = "TURN_DATE")
    private LocalDate turnDate;

    /**
     * AGENT_CATE
     */
    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

    /**
     * DEPT_TRAIN_ID
     */
    @Column(name = "DEPT_TRAIN_ID")
    private String deptTrainId;

    /**
     * AREA_TRAIN_ID
     */
    @Column(name = "AREA_TRAIN_ID")
    private String areaTrainId;

    /**
     * INDIRECT_TRAIN_ID
     */
    @Column(name = "INDIRECT_TRAIN_ID")
    private String indirectTrainId;

    /**
     * IND_DEPT_TRAIN_ID
     */
    @Column(name = "IND_DEPT_TRAIN_ID")
    private String indDeptTrainId;

    /**
     * GROUP_TRAIN_DATE
     */
    @Column(name = "GROUP_TRAIN_DATE")
    private LocalDate groupTrainDate;

    /**
     * DEPT_TRAIN_DATE
     */
    @Column(name = "DEPT_TRAIN_DATE")
    private LocalDate deptTrainDate;

    /**
     * AREA_TRAIN_DATE
     */
    @Column(name = "AREA_TRAIN_DATE")
    private LocalDate areaTrainDate;

    /**
     * DIMIS_APPLY_DATE
     */
    @Column(name = "DIMIS_APPLY_DATE")
    private LocalDate dimisApplyDate;

    /**
     * GREEN_PASSPORT
     */
    @Column(name = "GREEN_PASSPORT")
    private String greenPassport;

    /**
     * REENTER_FLAG
     */
    @Column(name = "REENTER_FLAG", nullable = false)
    private String reenterFlag;

    /**
     * SIGN_DATE
     */
    @Column(name = "SIGN_DATE")
    private LocalDate signDate;

    /**
     * END_DATE
     */
    @Column(name = "END_DATE")
    private LocalDate endDate;

    /**
     * INIT_GRADE_ID
     */
    @Column(name = "INIT_GRADE_ID")
    private String initGradeId;

    /**
     * REAL_NAME
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * GRADE_BEGIN_DATE
     */
    @Column(name = "GRADE_BEGIN_DATE")
    private LocalDate gradeBeginDate;

    /**
     * DEPT_BEGIN_DATE
     */
    @Column(name = "DEPT_BEGIN_DATE")
    private LocalDate deptBeginDate;

}
