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
 * [202004][Commission split handling for campaign] configure agent campaign info by full fyc
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_CAMPAIGN_CONFIG")
public class TAgentCampaignConfig extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [202004][Commission split handling for campaign] list_id
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * [202004][Commission split handling for campaign] campaign_code
     */
    @Column(name = "CAMPAIGN_CODE")
    private String campaignCode;

    /**
     * [202004][Commission split handling for campaign] product_id
     */
    @Column(name = "PRODUCT_ID")
    private String productId;

    /**
     * [202004][Commission split handling for campaign] internal_id
     */
    @Column(name = "INTERNAL_ID")
    private String internalId;

    /**
     * [202004][Commission split handling for campaign] agent_id
     */
    @Column(name = "AGENT_CODE")
    private String agentCode;

    /**
     * [202004][Commission split handling for campaign] full_ryc_year
     */
    @Column(name = "FULL_RYC_YEAR")
    private String fullRycYear;

}
