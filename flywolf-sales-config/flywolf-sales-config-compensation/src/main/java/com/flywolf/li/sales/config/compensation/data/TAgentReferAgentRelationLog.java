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
 * [202201][CM-859]Referred Broker Management Enhancement
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_REFER_AGENT_RELATION_LOG")
public class TAgentReferAgentRelationLog extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [202201][CM-859] LOG ID
     */
    @Id
    @Column(name = "LOG_ID", nullable = false)
    private String logId;

    /**
     * [202201][CM-859] TYPE OF LOG
     */
    @Column(name = "LOG_TYPE", nullable = false)
    private String logType;

    /**
     * [202201][CM-859] CHANGE ID
     */
    @Column(name = "CHANGE_ID", nullable = false)
    private String changeId;

    /**
     * [202201][CM-859] SALES CHANGE ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

    /**
     * [202201][CM-859] LAST COMMIT FLAG
     */
    @Column(name = "LAST_CMT_FLG", nullable = false)
    private String lastCmtFlg;

    /**
     * [202201][CM-859] LIST ID
     */
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * [202201][CM-859] Agent if of Agent
     */
    @Column(name = "AGENT_ID")
    private String agentId;

    /**
     * [202201][CM-859] Agent code of  agent
     */
    @Column(name = "AGENT_CODE")
    private String agentCode;

    /**
     * [202201][CM-859] Agent if of refer Agent
     */
    @Column(name = "REFER_AGETNT_ID")
    private String referAgetntId;

    /**
     * [202201][CM-859] Agent code of refer agent
     */
    @Column(name = "REFER_AGENT_CODE")
    private String referAgentCode;

    /**
     * [202201][CM-859] effective month
     */
    @Column(name = "EFFECTIVE_MONTH")
    private String effectiveMonth;

    /**
     * [202201][CM-859] end month
     */
    @Column(name = "END_MONTH")
    private String endMonth;

    /**
     * [202201][CM-859] status 0:Active;1:inactive
     */
    @Column(name = "STATUS")
    private String STATUS;

    /**
     * [202201][CM-859] insert user id
     */
    @Column(name = "INSERT_ID")
    private String insertId;

    /**
     * [202201][CM-859] update the relation time
     */
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    /**
     * [202201][CM-859] updater of update opt
     */
    @Column(name = "UPDATE_ID")
    private String updateId;

}
