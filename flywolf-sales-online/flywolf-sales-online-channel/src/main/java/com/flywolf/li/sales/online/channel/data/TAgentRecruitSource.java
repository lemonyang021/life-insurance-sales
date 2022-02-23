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
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_RECRUIT_SOURCE")
public class TAgentRecruitSource extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * RECRUIT_SOURCE
     */
    @Id
    @Column(name = "RECRUIT_SOURCE", nullable = false)
    private String recruitSource;

    /**
     * SOURCE_NAME
     */
    @Column(name = "SOURCE_NAME", nullable = false)
    private String sourceName;

}
