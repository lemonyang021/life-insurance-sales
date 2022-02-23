package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_AGENCY")
@EqualsAndHashCode(callSuper = true)
public class TAgency extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENCY_CODE
     */
    @Id
    @Column(name = "AGENCY_CODE", nullable = false)
    private String agencyCode;

    /**
     * AGENCY_NAME
     */
    @Column(name = "AGENCY_NAME", nullable = false)
    private String agencyName;

    /**
     * AGENCY_TYPE
     */
    @Column(name = "AGENCY_TYPE", nullable = false)
    private String agencyType;

    /**
     * TELEPHONE
     */
    @Column(name = "TELEPHONE")
    private String TELEPHONE;

    /**
     * ORGAN_ID
     */
    @Column(name = "ORGAN_ID")
    private String organId;

    /**
     * MANAGER_ID
     */
    @Column(name = "MANAGER_ID")
    private String managerId;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID")
    private String deptId;

    /**
     * STATUS
     */
    @Column(name = "STATUS", nullable = false)
    private String STATUS;

    /**
     * CREATE_DATE
     */
    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDate createDate;

    /**
     * RECALL_DATE
     */
    @Column(name = "RECALL_DATE")
    private LocalDate recallDate;

    /**
     * FAX
     */
    @Column(name = "FAX")
    private String FAX;

    /**
     * ADDRESS_ID
     */
    @Column(name = "ADDRESS_ID")
    private String addressId;

}
