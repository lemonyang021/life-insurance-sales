package com.flywolf.li.sales.config.compensation.data;

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
@Table(name = "T_AGENT_AWARD_ITEM")
@EqualsAndHashCode(callSuper = true)
public class TAgentAwardItem extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AWARD_ITEM
     */
    @Id
    @Column(name = "AWARD_ITEM", nullable = false)
    private String awardItem;

    /**
     * AWARD_NAME
     */
    @Column(name = "AWARD_NAME", nullable = false)
    private String awardName;

}
