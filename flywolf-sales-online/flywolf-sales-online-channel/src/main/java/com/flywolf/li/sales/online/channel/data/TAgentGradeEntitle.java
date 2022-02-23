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
@Table(name = "T_AGENT_GRADE_ENTITLE")
public class TAgentGradeEntitle extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ENTITLE_ID
     */
    @Id
    @Column(name = "ENTITLE_ID", nullable = false)
    private String entitleId;

    /**
     * AGENT_GRADE
     */
    @Column(name = "AGENT_GRADE", nullable = false)
    private String agentGrade;

    /**
     * COMMISION_TYPE_ID
     */
    @Column(name = "COMMISION_TYPE_ID", nullable = false)
    private String commisionTypeId;

    /**
     * [201510][Compensation for ILP]RENEWAL YEAR OVERRIDER INDI
     */
    @Column(name = "OR_TYPE")
    private String orType;

}
