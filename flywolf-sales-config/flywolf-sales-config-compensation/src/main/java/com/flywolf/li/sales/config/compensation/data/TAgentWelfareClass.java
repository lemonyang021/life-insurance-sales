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
@Table(name = "T_AGENT_WELFARE_CLASS")
public class TAgentWelfareClass extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * WELFARE_CLASS
     */
    @Id
    @Column(name = "WELFARE_CLASS", nullable = false)
    private String welfareClass;

    /**
     * CLASS_DESC
     */
    @Column(name = "CLASS_DESC", nullable = false)
    private String classDesc;

}
