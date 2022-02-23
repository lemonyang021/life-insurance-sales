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
 * [201911][Compensation Revamp P2]Data table to store the Consecutive Qualifying Years data for LBB LOG
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_LBB_BONUS_CONFIG_LOG")
public class TAgentLbbBonusConfigLog extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201911][Compensation Revamp P2]configure id
     */
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * [201911][Compensation Revamp P2]agent id
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201911][Compensation Revamp P2]unit id
     */
    @Column(name = "DEPT_ID")
    private String deptId;

    /**
     * [201911][Compensation Revamp P2]district id
     */
    @Column(name = "DISTRICT_ID")
    private String districtId;

    /**
     * [201911][Compensation Revamp P2]bonus period
     */
    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

    /**
     * [201909][Compensation Revamp P2]personal Annual FYC of last year
     */
    @Column(name = "LAST_ANNUAL_FYC")
    private String lastAnnualFyc;

    /**
     * [201911][Compensation Revamp P2]PR of last year
     */
    @Column(name = "LAST_PR")
    private String lastPr;

    /**
     * [201911][Compensation Revamp P2]Consecutive Qualifying Years
     */
    @Column(name = "QUALIFY_YEAR", nullable = false)
    private String qualifyYear;

    /**
     * [201911][Compensation Revamp P2]available Qualification Holiday
     */
    @Column(name = "HOLIDAY_NO", nullable = false)
    private String holidayNo;

    /**
     * [201911][Compensation Revamp P2]Qualification Holiday total(up to 2)
     */
    @Column(name = "HOLIDAY_SUM", nullable = false)
    private String holidaySum;

    /**
     * [201911][Compensation Revamp P2]PK Log id
     */
    @Id
    @Column(name = "LOG_ID", nullable = false)
    private String logId;

    /**
     * [201911][Compensation Revamp P2]Log type
     */
    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    /**
     * [201911][Compensation Revamp P2] change id
     */
    @Column(name = "CHANGE_ID", nullable = false)
    private String changeId;

    /**
     * [201911][Compensation Revamp P2]last cmt flag indi
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * [201911][Compensation Revamp P2]sales change id
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

}
