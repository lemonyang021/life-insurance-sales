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
 * mapping between Oscar2 and eligible broker and CA
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_PRODUCT_MAPPING")
public class TAgentProductMapping extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * product id
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    /**
     * Replaced product id
     */
    @Id
    @Column(name = "REPL_PRODUCT_ID", nullable = false)
    private String replProductId;

    /**
     * agent id
     */
    @Id
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * insert time
     */
    @Column(name = "INSERT_DATE")
    private LocalDate insertDate;

    /**
     * update time
     */
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    /**
     * [202105][Oscar2]sale_date
     */
    @Column(name = "SALE_DATE")
    private LocalDate saleDate;

}
