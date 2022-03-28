package com.flywolf.li.sales.dou.entity;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_dou_channel")
@Data
public class DouChannel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8392351939775505443L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "dou_id",nullable = false)
    private Long douId;
    @Column(name = "channel_id",nullable = false)
    private Long channelId;
}