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
 * [201801][NB674]Relation description between policy service agent's agent cate and policy document
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_CATE_DOC_MAPPING")
public class TAgentCateDocMapping extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201801][NB674]Agent cate and policy document mapping relation id
     */
    @Id
    @Column(name = "CATE_MAPPING_ID", nullable = false)
    private String cateMappingId;

    /**
     * [201801][NB674]Agent cate and policy document mapping relation code
     */
    @Column(name = "MAPPING_CODE")
    private String mappingCode;

    /**
     * [201801][NB674]Agent cate
     */
    @Column(name = "AGENT_CATE")
    private String agentCate;

    /**
     * [201801][NB674]Agent cate and policy document mapping relation remark
     */
    @Column(name = "REMARK")
    private String REMARK;

    /**
     * [201801][NB674]Agent cate related policy document id
     */
    @Column(name = "DOC_ID")
    private String docId;

    /**
     * [201801][NB674]policy holder correspondence language which same as policy document language
     */
    @Column(name = "LANG_ID")
    private String langId;

}
