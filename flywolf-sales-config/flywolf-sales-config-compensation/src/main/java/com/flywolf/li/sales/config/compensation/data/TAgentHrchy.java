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
@Table(name = "T_AGENT_HRCHY")
@EqualsAndHashCode(callSuper = true)
public class TAgentHrchy extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * HRCHY_POS
     */
    @Id
    @Column(name = "HRCHY_POS", nullable = false)
    private String hrchyPos;

    /**
     * HRCHY_LVL
     */
    @Column(name = "HRCHY_LVL")
    private String hrchyLvl;

    /**
     * HRCHY_DESC
     */
    @Column(name = "HRCHY_DESC")
    private String hrchyDesc;

}
