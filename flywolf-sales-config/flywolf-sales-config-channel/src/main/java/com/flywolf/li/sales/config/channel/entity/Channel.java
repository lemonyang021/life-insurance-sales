package com.flywolf.li.sales.config.channel.entity;

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
@Table(name = "t_channel")
@DynamicUpdate
@DynamicInsert
public class Channel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2270158413421004264L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "channel_name", nullable = false)
    private String channelName;

    @Column(name = "channel_code", nullable = false)
    private String channelCode;

    @Column(name = "category_code",nullable = false)
    private String categoryCode;

}