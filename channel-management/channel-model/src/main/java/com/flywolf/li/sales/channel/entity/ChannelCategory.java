package com.flywolf.li.sales.channel.entity;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_channel_category", uniqueConstraints = {
        @UniqueConstraint(name = "uni_category_code", columnNames = {"category_code"})
})
public class ChannelCategory extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1708979070594182865L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "category_code", unique = true, nullable = false)
    private String categoryCode;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

}