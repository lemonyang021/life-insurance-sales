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
@Table(name = "T_AGENT_AWARD_CLASS")
@EqualsAndHashCode(callSuper = true)
public class TAgentAwardClass extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AWARD_CLASS
     */
    @Id
    @Column(name = "AWARD_CLASS", nullable = false)
    private String awardClass;

    /**
     * CLASS_NAME
     */
    @Column(name = "CLASS_NAME", nullable = false)
    private String className;

}
