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
@Table(name = "T_AGENCY_STATUS")
@EqualsAndHashCode(callSuper = true)
public class TAgencyStatus extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENCY_STATUS
     */
    @Id
    @Column(name = "AGENCY_STATUS", nullable = false)
    private String agencyStatus;

    /**
     * STATUS_NAME
     */
    @Column(name = "STATUS_NAME", nullable = false)
    private String statusName;

}
