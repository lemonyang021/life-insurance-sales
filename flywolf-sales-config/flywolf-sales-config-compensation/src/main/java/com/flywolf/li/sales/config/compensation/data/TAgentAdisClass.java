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
@Table(name = "T_AGENT_ADIS_CLASS")
@EqualsAndHashCode(callSuper = true)
public class TAgentAdisClass extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ADIS_CLASS
     */
    @Id
    @Column(name = "ADIS_CLASS", nullable = false)
    private String adisClass;

    /**
     * CLASS_DESC
     */
    @Column(name = "CLASS_DESC", nullable = false)
    private String classDesc;

}
