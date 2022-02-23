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
@Table(name = "T_AGENCY_EMPLOYEE")
@EqualsAndHashCode(callSuper = true)
public class TAgencyEmployee extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * EMP_ID
     */
    @Id
    @Column(name = "EMP_ID", nullable = false)
    private String empId;

    /**
     * REAL_NAME
     */
    @Column(name = "REAL_NAME", nullable = false)
    private String realName;

    /**
     * USER_NAME
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * PASSWORD
     */
    @Column(name = "PASSWORD")
    private String PASSWORD;

    /**
     * PASSWORD_CHANGE
     */
    @Column(name = "PASSWORD_CHANGE")
    private LocalDate passwordChange;

    /**
     * GENDER
     */
    @Column(name = "GENDER", nullable = false)
    private String GENDER;

    /**
     * BIRTHDAY
     */
    @Column(name = "BIRTHDAY")
    private LocalDate BIRTHDAY;

    /**
     * CERTI_TYPE
     */
    @Column(name = "CERTI_TYPE")
    private String certiType;

    /**
     * CERTI_CODE
     */
    @Column(name = "CERTI_CODE")
    private String certiCode;

    /**
     * EDUCATION_ID
     */
    @Column(name = "EDUCATION_ID")
    private String educationId;

    /**
     * EMAIL
     */
    @Column(name = "EMAIL")
    private String EMAIL;

    /**
     * TELEPHONE
     */
    @Column(name = "TELEPHONE")
    private String TELEPHONE;

    /**
     * CELLER_TEL
     */
    @Column(name = "CELLER_TEL")
    private String cellerTel;

    /**
     * AGENCY_CODE
     */
    @Column(name = "AGENCY_CODE", nullable = false)
    private String agencyCode;

    /**
     * EXPERENCED
     */
    @Column(name = "EXPERENCED", nullable = false)
    private String EXPERENCED;

    /**
     * CERTIFICATED
     */
    @Column(name = "CERTIFICATED", nullable = false)
    private String CERTIFICATED;

    /**
     * INSURER_JOB
     */
    @Column(name = "INSURER_JOB", nullable = false)
    private String insurerJob;

    /**
     * INSURER_NAME
     */
    @Column(name = "INSURER_NAME")
    private String insurerName;

    /**
     * OPERATED
     */
    @Column(name = "OPERATED", nullable = false)
    private String OPERATED;

    /**
     * OTHER_OPERATED
     */
    @Column(name = "OTHER_OPERATED", nullable = false)
    private String otherOperated;

}
