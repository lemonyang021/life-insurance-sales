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
@Table(name = "t_dou", uniqueConstraints = {
        @UniqueConstraint(name = "uni_code", columnNames = {"code"})
}, indexes = {
        @Index(name = "idx_leader", columnList = "leader"),
        @Index(name = "idx_end_reason", columnList = "end_reason"),
        @Index(name = "idx_effective_date", columnList = "effective_date"),
        @Index(name = "idx_end_date", columnList = "end_date")
})
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


    /*@ManyToOne(targetEntity = DouChannel.class)
    @JoinColumn(name = "id", referencedColumnName = "dou_id")
    private DouChannel douChannelMapping;

    @ManyToOne(targetEntity = DouEndReason.class)
    @JoinColumn(name = "end_reason", referencedColumnName = "id")
    private DouEndReason douEndReason;*/


}