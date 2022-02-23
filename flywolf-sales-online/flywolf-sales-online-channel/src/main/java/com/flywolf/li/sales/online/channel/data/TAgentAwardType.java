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
@Table(name = "T_AGENT_AWARD_TYPE")
@EqualsAndHashCode(callSuper = true)
public class TAgentAwardType extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AWARD_TYPE
     */
    @Id
    @Column(name = "AWARD_TYPE", nullable = false)
    private String awardType;

    /**
     * TYPE_NAME
     */
    @Column(name = "TYPE_NAME", nullable = false)
    private String typeName;

    /**
     * TYPE_DESC
     */
    @Column(name = "TYPE_DESC")
    private String typeDesc;

}
