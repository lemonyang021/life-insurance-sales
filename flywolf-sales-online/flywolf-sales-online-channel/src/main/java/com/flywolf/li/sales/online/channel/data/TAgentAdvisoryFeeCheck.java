package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * [Product Define Table][201501][Advisory Fee for IFA] Table-driven for "Advisory Fee For IFA"
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_ADVISORY_FEE_CHECK")
public class TAgentAdvisoryFeeCheck extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201501][Advisory Fee for IFA] LIST ID
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * [201501][Advisory Fee for IFA] PRODUCT ID
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    /**
     * [201501][Advisory Fee for IFA] AGENT CATE
     */
    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

}
