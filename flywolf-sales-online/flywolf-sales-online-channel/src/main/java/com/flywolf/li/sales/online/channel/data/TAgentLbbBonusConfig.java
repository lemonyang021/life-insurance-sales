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
 * [201909][Compensation Revamp P2]Data table to store the Consecutive Qualifying Years data for LBB
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_LBB_BONUS_CONFIG")
public class TAgentLbbBonusConfig extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201909][Compensation Revamp P2]configure id
     */
    @Id
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * [201909][Compensation Revamp P2]agent id
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201909][Compensation Revamp P2]unit id
     */
    @Column(name = "DEPT_ID")
    private String deptId;

    /**
     * [201909][Compensation Revamp P2]district id
     */
    @Column(name = "DISTRICT_ID")
    private String districtId;

    /**
     * [201909][Compensation Revamp P2]bonus period
     */
    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

    /**
     * [201909][Compensation Revamp P2]personal Annual FYC of last year
     */
    @Column(name = "LAST_ANNUAL_FYC")
    private String lastAnnualFyc;

    /**
     * [201909][Compensation Revamp P2]PR of last year
     */
    @Column(name = "LAST_PR")
    private String lastPr;

    /**
     * [201909][Compensation Revamp P2]Consecutive Qualifying Years
     */
    @Column(name = "QUALIFY_YEAR", nullable = false)
    private String qualifyYear;

    /**
     * [201909][Compensation Revamp P2]available Qualification Holiday
     */
    @Column(name = "HOLIDAY_NO", nullable = false)
    private String holidayNo;

    /**
     * [201909][Compensation Revamp P2]Qualification Holiday total(up to 2)
     */
    @Column(name = "HOLIDAY_SUM", nullable = false)
    private String holidaySum;

    /**
     * [202106][CM822-CM824]months with Monthly Personal FYC at config amount or above
     */
    @Column(name = "CRITERIA_MONTH")
    private String criteriaMonth;

}
