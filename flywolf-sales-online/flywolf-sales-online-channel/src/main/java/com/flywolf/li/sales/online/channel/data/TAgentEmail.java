package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * [201812][CR-P03-22]table reffer to DMS.T_AGENT_EMAIL
 */
@Data
@Entity
@Table(name = "T_AGENT_EMAIL")
@EqualsAndHashCode(callSuper = true)
public class TAgentEmail extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201812][CR-P03-22]Reffer to t_agent.agent_code
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * [201812][CR-P03-22]EMAIL
     */
    @Column(name = "EMAIL")
    private String EMAIL;

    /**
     * [201812][CR-P03-22]EXPIRE_DATE
     */
    @Column(name = "EXPIRE_DATE")
    private LocalDate expireDate;

    /**
     * [201812][CR-P03-22]Primary key
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

}
