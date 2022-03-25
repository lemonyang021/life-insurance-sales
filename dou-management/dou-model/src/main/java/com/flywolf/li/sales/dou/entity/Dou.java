package com.flywolf.li.sales.dou.entity;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_dou")
@Data
@DynamicUpdate
@DynamicInsert
public class Dou extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 2030954345690062319L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "contact_person", nullable = false)
    private String contactPerson;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Column(name = "leader", nullable = false)
    private String leader;
    @Column(name = "effective_date", nullable = false)
    private Date effectiveDate;
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Column(name = "end_reason", nullable = true)
    private Integer endReason;

}