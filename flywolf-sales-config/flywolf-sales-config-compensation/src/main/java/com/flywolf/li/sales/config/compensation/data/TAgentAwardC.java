package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_AGENT_AWARD_C")
@EqualsAndHashCode(callSuper = true)
public class TAgentAwardC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AWARD_ID", nullable = false)
    private String awardId;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "AWARD_TYPE", nullable = false)
    private String awardType;

    @Column(name = "AWARD_CLASS")
    private String awardClass;

    @Column(name = "AWARD_YEAR")
    private String awardYear;

    @Column(name = "EFFECTIVE_DATE")
    private LocalDate effectiveDate;

    @Column(name = "EXPIRE_DATE")
    private LocalDate expireDate;

    @Column(name = "AWARD_ITEM", nullable = false)
    private String awardItem;

}
