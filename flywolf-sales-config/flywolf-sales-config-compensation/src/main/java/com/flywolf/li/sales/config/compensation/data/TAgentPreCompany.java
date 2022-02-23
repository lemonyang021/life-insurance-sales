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
@Table(name = "T_AGENT_PRE_COMPANY")
public class TAgentPreCompany extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PRE_COMPANY
     */
    @Id
    @Column(name = "PRE_COMPANY", nullable = false)
    private String preCompany;

    /**
     * COMPANY_NAME
     */
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

}
