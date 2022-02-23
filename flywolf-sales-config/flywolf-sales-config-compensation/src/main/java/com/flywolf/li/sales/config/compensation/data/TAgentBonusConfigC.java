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
@Table(name = "T_AGENT_BONUS_CONFIG_C")
public class TAgentBonusConfigC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CONFIG_ID", nullable = false)
    private String configId;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "COMMISION_TYPE", nullable = false)
    private String commisionType;

    @Column(name = "ELIGIBLE_INDI", nullable = false)
    private String eligibleIndi;

    @Column(name = "ELIGIBLE_AMOUNT", nullable = false)
    private String eligibleAmount;

    @Column(name = "BONUS_PERIOD", nullable = false)
    private String bonusPeriod;

}
