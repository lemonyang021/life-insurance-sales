package com.flywolf.li.sales.dou.service.bo;

import com.flywolf.li.framework.bo.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class DouBO extends BaseBO {
    private Long id;
    private String name;
    private String code;
    private String contactPerson;
    private String contactPhone;
    private String leader;
    private Date effectiveDate;
    private Date endDate;
    private Integer endReason;
}
