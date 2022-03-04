package com.flywolf.li.sales.config.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "t_channel")
public class Channel extends ExtendableAuditEntity implements Serializable {
    private static final long serialVersionUID = -2270158413421004264L;
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "channel_name", nullable = false)
    private String channelName;

    @Column(name = "channel_code", nullable = false)
    private String channelCode;

}