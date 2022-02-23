package com.flywolf.li.sales.config.channel.data;

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
@Table(name = "T_AGENT_CATE")
@EqualsAndHashCode(callSuper = true)
public class TAgentCate extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_CATE
     */
    @Id
    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

    /**
     * CATE_NAME
     */
    @Column(name = "CATE_NAME")
    private String cateName;

    /**
     * CATE_CODE
     */
    @Column(name = "CATE_CODE")
    private String cateCode;

    /**
     * PARTY_TYPE
     */
    @Column(name = "PARTY_TYPE")
    private String partyType;

    /**
     * IFA_INDI
     */
    @Column(name = "IR_INDI")
    private String irIndi;

    /**
     * [202011][NB-776]ifa_related_indi
     */
    @Column(name = "IFA_RELATED_INDI")
    private String ifaRelatedIndi;

}
