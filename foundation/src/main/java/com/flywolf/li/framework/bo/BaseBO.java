package com.flywolf.li.framework.bo;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseBO {
    /**
     * Who created
      */

    protected Long insertedBy;
    /**
     * Who updated at latest
     */
    protected Long updatedBy;
    /**
     * When created at application time
     */
    protected Date insertTime;
    /**
     * When updated at latest at application time
     */
    protected Date updateTime;
}
