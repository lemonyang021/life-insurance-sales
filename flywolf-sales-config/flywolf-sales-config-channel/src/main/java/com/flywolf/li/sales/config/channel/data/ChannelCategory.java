package com.flywolf.li.sales.config.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "t_channel_category")
public class ChannelCategory extends ExtendableAuditEntity implements Serializable {
    private static final long serialVersionUID = 1708979070594182865L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "category_code", nullable = false)
    private String categoryCode;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

}