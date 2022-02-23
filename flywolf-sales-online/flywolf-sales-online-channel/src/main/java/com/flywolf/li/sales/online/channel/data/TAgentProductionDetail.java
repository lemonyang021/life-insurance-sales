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
@Table(name = "T_AGENT_PRODUCTION_DETAIL")
public class TAgentProductionDetail extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * DETAIL_ID
     */
    @Id
    @Column(name = "DETAIL_ID", nullable = false)
    private String detailId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * PRDN_CATE
     */
    @Column(name = "PRDN_CATE", nullable = false)
    private String prdnCate;

    /**
     * AGENT_COUNT_AMOUNT
     */
    @Column(name = "AGENT_COUNT_AMOUNT", nullable = false)
    private String agentCountAmount;

    /**
     * PRDN_MONTH
     */
    @Column(name = "PRDN_MONTH", nullable = false)
    private String prdnMonth;

    /**
     * PRDN_ITEM
     */
    @Column(name = "PRDN_ITEM", nullable = false)
    private String prdnItem;

    /**
     * ORIGINAL_ID
     */
    @Column(name = "ORIGINAL_ID")
    private String originalId;

}
