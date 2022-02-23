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
@Table(name = "T_AGENT_ROLE")
@EqualsAndHashCode(callSuper = true)
public class TAgentRole extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private String roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

}
