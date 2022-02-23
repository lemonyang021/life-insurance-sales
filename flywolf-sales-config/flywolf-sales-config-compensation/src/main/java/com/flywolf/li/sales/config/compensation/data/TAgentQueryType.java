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
@Table(name = "T_AGENT_QUERY_TYPE")
@EqualsAndHashCode(callSuper = true)
public class TAgentQueryType extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * TYPE_ID
     */
    @Id
    @Column(name = "TYPE_ID", nullable = false)
    private String typeId;

    /**
     * TYPE_DESC
     */
    @Column(name = "TYPE_DESC", nullable = false)
    private String typeDesc;

    /**
     * IS_VALID
     */
    @Column(name = "IS_VALID", nullable = false)
    private String valid;

}
