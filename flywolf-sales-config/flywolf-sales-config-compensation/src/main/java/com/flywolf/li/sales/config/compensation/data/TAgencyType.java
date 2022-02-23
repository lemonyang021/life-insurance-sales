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
@Table(name = "T_AGENCY_TYPE")
@EqualsAndHashCode(callSuper = true)
public class TAgencyType extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENCY_TYPE
     */
    @Id
    @Column(name = "AGENCY_TYPE", nullable = false)
    private String agencyType;

    /**
     * TYPE_NAME
     */
    @Column(name = "TYPE_NAME", nullable = false)
    private String typeName;

}
