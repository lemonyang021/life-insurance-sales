package com.flywolf.li.sales.dou.entity;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_dou_end_reason", uniqueConstraints = {
        @UniqueConstraint(name = "uni_reason_code", columnNames = {"reason_code"})
})
@Data
public class DouEndReason extends BaseEntity {
    private static final long serialVersionUID = 2614170350986993896L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "reason_code", nullable = false)
    private String endReasonCode;
    @Column(name = "reason_desc", nullable = false)
    private String endReasonDesc;
}