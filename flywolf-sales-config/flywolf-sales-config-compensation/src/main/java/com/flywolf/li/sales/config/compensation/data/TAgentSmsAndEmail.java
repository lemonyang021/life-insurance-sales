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
 * [201801][CM-666] agent SMS and Email
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_SMS_AND_EMAIL")
public class TAgentSmsAndEmail extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201801][CM-666] select id
     */
    @Id
    @Column(name = "SELECT_ID", nullable = false)
    private String selectId;

    /**
     * [201801][CM-666] option
     */
    @Column(name = "SELECT_OPTION", nullable = false)
    private String selectOption;

    /**
     * [201801][CM-666] sms preset id
     */
    @Column(name = "SMS_PRESET_ID")
    private String smsPresetId;

    /**
     * [201801][CM-666] email preset id
     */
    @Column(name = "EMAIL_PRESET_ID")
    private String emailPresetId;

}
