package com.flywolf.li.sales.channel.entity;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_channel_category")
public class ChannelCategory extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1708979070594182865L;
    @Id
    @Column(name = "category_code", nullable = false,length = 200)
    private String categoryCode;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

}