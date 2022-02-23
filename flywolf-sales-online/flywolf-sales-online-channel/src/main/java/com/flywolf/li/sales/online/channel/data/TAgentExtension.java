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
@Table(name = "T_AGENT_EXTENSION")
@EqualsAndHashCode(callSuper = true)
public class TAgentExtension extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_ID
     */
    @Id
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * HRCHY_POS
     */
    @Column(name = "HRCHY_POS")
    private String hrchyPos;

    /**
     * CONTRACT_DATE
     */
    @Column(name = "CONTRACT_DATE")
    private LocalDate contractDate;

    /**
     * CONTRACT_CODE
     */
    @Column(name = "CONTRACT_CODE")
    private String contractCode;

    /**
     * DESPACTCH_TYPE
     */
    @Column(name = "DESPACTCH_TYPE")
    private String despactchType;

    /**
     * OFF_FUND_IND
     */
    @Column(name = "OFF_FUND_IND")
    private String offFundInd;

    /**
     * SUSPEND_IND
     */
    @Column(name = "SUSPEND_IND")
    private String suspendInd;

    /**
     * PS_IND
     */
    @Column(name = "PS_IND")
    private String psInd;

    /**
     * PS_IND_DATE
     */
    @Column(name = "PS_IND_DATE")
    private LocalDate psIndDate;

    /**
     * SP_IND
     */
    @Column(name = "SP_IND")
    private String spInd;

    /**
     * SP_IND_DATE
     */
    @Column(name = "SP_IND_DATE")
    private LocalDate spIndDate;

    /**
     * UL_IND
     */
    @Column(name = "UL_IND")
    private String ulInd;

    /**
     * HEALTH_IND
     */
    @Column(name = "HEALTH_IND")
    private String healthInd;

    /**
     * SRS_IND
     */
    @Column(name = "SRS_IND")
    private String srsInd;

    /**
     * CPFIS_IND
     */
    @Column(name = "CPFIS_IND")
    private String cpfisInd;

    /**
     * IO_AGENT_CODE
     */
    @Column(name = "IO_AGENT_CODE")
    private String ioAgentCode;

    /**
     * IO_EFF_DATE
     */
    @Column(name = "IO_EFF_DATE")
    private LocalDate ioEffDate;

    /**
     * GSM_AGENT_CODE
     */
    @Column(name = "GSM_AGENT_CODE")
    private String gsmAgentCode;

    /**
     * ADDR_NO
     */
    @Column(name = "ADDR_NO")
    private String addrNo;

    /**
     * IO_RANK
     */
    @Column(name = "IO_RANK")
    private String ioRank;

    /**
     * GSM_RANK
     */
    @Column(name = "GSM_RANK")
    private String gsmRank;

    /**
     * AGENT_LOC
     */
    @Column(name = "AGENT_LOC")
    private String agentLoc;

}
