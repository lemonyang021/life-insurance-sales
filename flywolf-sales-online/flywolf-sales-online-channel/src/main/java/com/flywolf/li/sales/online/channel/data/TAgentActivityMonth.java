package com.flywolf.li.sales.online.channel.data;

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
@Table(name = "T_AGENT_ACTIVITY_MONTH")
public class TAgentActivityMonth extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201812][bonus enhancement]activity id
     */
    @Id
    @Column(name = "ACTIVITY_ID", nullable = false)
    private String activityId;

    /**
     * [201812][bonus enhancement]agent id
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201812][bonus enhancement]calculate month
     */
    @Column(name = "CALC_MONTH")
    private String calcMonth;

    /**
     * [201812][bonus enhancement]current month case count
     */
    @Column(name = "CASE_COUNT")
    private String caseCount;

    /**
     * [201812][bonus enhancement]whether this month is activity month
     */
    @Column(name = "IS_ACTIVITY")
    private String activity;

    /**
     * [201812][bonus enhancement]accumulate activity month in current year
     */
    @Column(name = "ACC_ACTIVITY")
    private String accActivity;

}
