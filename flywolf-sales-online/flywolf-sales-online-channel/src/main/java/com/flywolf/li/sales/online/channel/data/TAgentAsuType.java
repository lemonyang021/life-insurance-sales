package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "T_AGENT_ASU_TYPE")
@EqualsAndHashCode(callSuper = true)
public class TAgentAsuType extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ASU_TYPE
     */
    @Id
    @Column(name = "ASU_TYPE", nullable = false)
    private String asuType;

    /**
     * ASU_NAME
     */
    @Column(name = "ASU_NAME", nullable = false)
    private String asuName;

}
