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
@Table(name = "T_AGENT_LEVEL_MOTHER")
public class TAgentLevelMother extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LEVEL_MOTHER_ID
     */
    @Id
    @Column(name = "LEVEL_MOTHER_ID", nullable = false)
    private String levelMotherId;

    /**
     * AGENT_ID
     */
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * DEPT_LEVEL
     */
    @Column(name = "DEPT_LEVEL", nullable = false)
    private String deptLevel;

    /**
     * MOTHER_ID
     */
    @Column(name = "MOTHER_ID")
    private String motherId;

    /**
     * RECORDER_ID
     */
    @Column(name = "RECORDER_ID", nullable = false)
    private String recorderId;

    /**
     * UPDATER_ID
     */
    @Column(name = "UPDATER_ID", nullable = false)
    private String updaterId;

    /**
     * VERSION_NUMBER
     */
    @Column(name = "VERSION_NUMBER", nullable = false)
    private String versionNumber;

}
