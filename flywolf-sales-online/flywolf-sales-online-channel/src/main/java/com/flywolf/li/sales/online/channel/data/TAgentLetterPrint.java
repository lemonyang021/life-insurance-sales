package com.flywolf.li.sales.online.channel.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_LETTER_PRINT")
public class TAgentLetterPrint extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * LIST ID
     */
    @Id
    @Column(name = "LIST_ID", nullable = false)
    private String listId;

    /**
     * SERVICE ID
     */
    @Column(name = "SERVICE_ID")
    private String serviceId;

    /**
     * SALES CHG ID
     */
    @Column(name = "SALES_CHG_ID")
    private String salesChgId;

    /**
     * GRADE CHANGE REASON
     */
    @Column(name = "GRADE_CHG_REASON")
    private String gradeChgReason;

    /**
     * FINISH TIME
     */
    @Column(name = "FINISH_TIME")
    private LocalDate finishTime;

    /**
     * PRINT TIME
     */
    @Column(name = "PRINT_TIME")
    private LocalDate printTime;

    /**
     * PRINT INDI
     */
    @Column(name = "PRINT_INDI", nullable = false)
    private String printIndi;

    /**
     * RECORDER ID
     */
    @Column(name = "RECORDER_ID")
    private String recorderId;

}
