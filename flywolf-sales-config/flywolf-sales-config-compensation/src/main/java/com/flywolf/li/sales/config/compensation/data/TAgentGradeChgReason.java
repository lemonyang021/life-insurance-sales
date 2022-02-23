package com.flywolf.li.sales.config.compensation.data;

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
@Table(name = "T_AGENT_GRADE_CHG_REASON")
public class TAgentGradeChgReason extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * GRADE_CHG_REASON
     */
    @Id
    @Column(name = "GRADE_CHG_REASON", nullable = false)
    private String gradeChgReason;

    /**
     * REASON_DESC
     */
    @Column(name = "REASON_DESC", nullable = false)
    private String reasonDesc;

}
