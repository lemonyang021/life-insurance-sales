package com.flywolf.li.sales.config.compensation.data;

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
 * [202009][CM-786]relation of agent and  refer agent
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_REFER_AGENT_RELATION")
public class TAgentReferAgentRelation extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [202009][CM-786] pk of T_AGENT_REFER_AGENT_RELATION
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * [202009][CM-786] Agent if of Agent
     */
    @Column(name = "AGENT_ID")
    private String agentId;

    /**
     * [202009][CM-786] Agent code of  agent
     */
    @Column(name = "AGENT_CODE")
    private String agentCode;

    /**
     * [202009][CM-786] Agent if of refer Agent
     */
    @Column(name = "REFER_AGETNT_ID")
    private String referAgetntId;

    /**
     * [202009][CM-786] Agent code of refer agent
     */
    @Column(name = "REFER_AGENT_CODE")
    private String referAgentCode;

    /**
     * [202009][CM-786] effective month
     */
    @Column(name = "EFFECTIVE_MONTH")
    private String effectiveMonth;

    /**
     * [202009][CM-786] insert user id
     */
    @Column(name = "INSERT_ID")
    private String insertId;

    /**
     * [202009][CM-786] update the relation time
     */
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    /**
     * [202009][CM-786] updater of update opt
     */
    @Column(name = "UPDATE_ID")
    private String updateId;

    @Column(name = "END_MONTH")
    private String endMonth;

    @Column(name = "STATUS")
    private String STATUS;

}
