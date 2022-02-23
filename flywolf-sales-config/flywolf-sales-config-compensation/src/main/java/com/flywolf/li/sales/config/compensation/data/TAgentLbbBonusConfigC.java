package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_LBB_BONUS_CONFIG_C")
public class TAgentLbbBonusConfigC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "DEPT_ID")
    private String deptId;

    @Column(name = "DISTRICT_ID")
    private String districtId;

    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

    @Column(name = "LAST_ANNUAL_FYC")
    private String lastAnnualFyc;

    @Column(name = "LAST_PR")
    private String lastPr;

    @Column(name = "QUALIFY_YEAR", nullable = false)
    private String qualifyYear;

    @Column(name = "HOLIDAY_NO", nullable = false)
    private String holidayNo;

    @Column(name = "HOLIDAY_SUM", nullable = false)
    private String holidaySum;

}
