package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * [201812][bonus enhancement]agent activity month record
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_ACTIVITY_RECORD")
public class TAgentActivityRecord extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201812][bonus enhancement]activity id
     */
    @Id
    @Column(name = "ACTIVITY_ID", nullable = false)
    private String activityId;

    /**
     * [201812][bonus enhancement]bonus type
     */
    @Column(name = "BONUS_TYPE")
    private String bonusType;

    /**
     * [201812][bonus enhancement]calculate month
     */
    @Column(name = "CALC_MONTH")
    private String calcMonth;

    /**
     * [201812][bonus enhancement]activity ratio
     */
    @Column(name = "ACTIVITY_RATIO")
    private String activityRatio;

    /**
     * [201812][bonus enhancement]activity count
     */
    @Column(name = "ACTIVITY_COUNT")
    private String activityCount;

    /**
     * [201812][bonus enhancement]inforce count
     */
    @Column(name = "INFORCE_COUNT")
    private String inforceCount;

    /**
     * [201906][bonus enhancement P2]BONUS DEPT
     */
    @Column(name = "BONUS_DEPT")
    private String bonusDept;

}
