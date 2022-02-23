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
 * [201804][Cheque Printing Outsourcing]Oline Payment Approver Information
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_AGENT_PAYMENT_APPROVER")
public class TAgentPaymentApprover extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * [201804][Cheque Printing Outsourcing]primary key of approver information
     */
    @Id
    @Column(name = "APPROVER_ID", nullable = false)
    private String approverId;

    /**
     * [201804][Cheque Printing Outsourcing]approver name
     */
    @Column(name = "PAYMENT_APPROVER")
    private String paymentApprover;

    /**
     * [201804][Cheque Printing Outsourcing]payment amount limit for every approver
     */
    @Column(name = "PAYMENT_AMOUNT_LIMIT")
    private String paymentAmountLimit;

    /**
     * [201804][Cheque Printing Outsourcing]whether the approver record can be used
     */
    @Column(name = "IN_USE")
    private String inUse;

}
