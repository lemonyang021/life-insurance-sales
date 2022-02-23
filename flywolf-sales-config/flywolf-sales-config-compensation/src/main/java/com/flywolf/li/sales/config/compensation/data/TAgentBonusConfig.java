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
@Table(name = "T_AGENT_BONUS_CONFIG")
public class TAgentBonusConfig extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CONFIG_ID
     */
    @Id
    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * COMMISION_TYPE
     */
    @Column(name = "COMMISION_TYPE", nullable = false)
    private String commisionType;

    /**
     * ELIGIBLE_INDI
     */
    @Column(name = "ELIGIBLE_INDI", nullable = false)
    private String eligibleIndi;

    /**
     * ELIGIBLE_AMOUNT
     */
    @Column(name = "ELIGIBLE_AMOUNT", nullable = false)
    private String eligibleAmount;

    /**
     * BONUS_PERIOD
     */
    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

    /**
     * GB_MAIN_AFYC
     */
    @Column(name = "GB_MAIN_AFYC")
    private String gbMainAfyc;

    /**
     * GB_PRE_YR_AFYC
     */
    @Column(name = "GB_PRE_YR_AFYC")
    private String gbPreYrAfyc;

    /**
     * GB_MAIN_NAFYC
     */
    @Column(name = "GB_MAIN_NAFYC")
    private String gbMainNafyc;

    /**
     * GB_PRE_YR_NAFYC
     */
    @Column(name = "GB_PRE_YR_NAFYC")
    private String gbPreYrNafyc;

    /**
     * Personal FYC
     */
    @Column(name = "GB_PERSONAL_FYC")
    private String gbPersonalFyc;

    /**
     * rate
     */
    @Column(name = "GB_RATE")
    private String gbRate;

}
