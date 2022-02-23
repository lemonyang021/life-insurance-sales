package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * [201801][CM-666 ] agent status clause
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_STATUS_CLAUSE")
public class TAgentStatusClause extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201801][CM-666 ] clause id
     */
    @Id
    @Column(name = "CLAUSE_ID", nullable = false)
    private String clauseId;

    /**
     * [201801][CM-666 ] clause description
     */
    @Column(name = "CLAUSE_DESC", nullable = false)
    private String clauseDesc;

}
