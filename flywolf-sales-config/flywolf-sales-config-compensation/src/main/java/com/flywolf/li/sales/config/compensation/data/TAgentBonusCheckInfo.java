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
 * [202106][CM822-CM824]MPB Bonus agent check resut
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_BONUS_CHECK_INFO")
public class TAgentBonusCheckInfo extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [202106][CM822-CM824]info id
     */
    @Id
    @Column(name = "INFO_ID", nullable = false)
    private String infoId;

    /**
     * [202106][CM822-CM824]config id
     */
    @Column(name = "CONFIG_ID")
    private String configId;

    /**
     * [202106][CM822-CM824]leader agent id
     */
    @Column(name = "LEADER_ID")
    private String leaderId;

    /**
     * [202106][CM822-CM824]agent id
     */
    @Column(name = "AGENT_ID")
    private String agentId;

    /**
     * [202106][CM822-CM824]commision type
     */
    @Column(name = "COMMISION_TYPE")
    private String commisionType;

    /**
     * [202106][CM822-CM824]year personal AFYC
     */
    @Column(name = "YEAR_AFYC")
    private String yearAfyc;

    /**
     * [202106][CM822-CM824]count Monthly Personal AFYC at 8,500 or above
     */
    @Column(name = "AFYC_CRITERIA_MON")
    private String afycCriteriaMon;

    /**
     * [202106][CM822-CM824]bonus period
     */
    @Column(name = "BONUS_PERIOD")
    private String bonusPeriod;

}
