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
@Table(name = "T_AGENT_PAY_METHOD")
@EqualsAndHashCode(callSuper = true)
public class TAgentPayMethod extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PAYMENT_METHOD
     */
    @Id
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private String paymentMethod;

    /**
     * METHOD_DESC
     */
    @Column(name = "METHOD_DESC", nullable = false)
    private String methodDesc;

    /**
     * MODE_ID
     */
    @Column(name = "MODE_ID")
    private String modeId;

}
