package com.flywolf.li.framework.entity;

import java.io.Serializable;
import java.util.Date;

import com.flywolf.li.framework.context.TenancyContext;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flywolf.li.framework.user.AppUserContext;



@Component("claimBsAuditDataInterceptor")
public class AuditDataInterceptor extends EmptyInterceptor {

  private static final long serialVersionUID = -4422966073052585725L;
  private static final Logger logger = LoggerFactory.getLogger(AuditDataInterceptor.class);
  @Autowired
  private AppUserContext appUser;
  
  private Date currentUserLocalTime() {
    return TenancyContext.getTenancy().getCurrentUserLocalTime();
//    return appUser.getCurrentUserLocalTime();
  }

  private Date currentTimestamp() {
    return new Date();
  }

  @Override
  public boolean onFlushDirty(Object entity, Serializable id, Object currentState[],
      Object previousState[], String propertyNames[], Type types[]) {
    boolean returnValue = false;
    for (int i = 0; i < propertyNames.length; i++) {
      if ("updateTime".equals(propertyNames[i])) {
        try {
          currentState[i] = currentUserLocalTime();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      } else if ("updateTimestamp".equals(propertyNames[i])) {
        try {
          currentState[i] = currentTimestamp();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      } else if ("updaterId".equals(propertyNames[i]) || "updatedBy".equals(propertyNames[i])) {
        try {
          currentState[i] = TenancyContext.getTenancy().getTenantUserId();//appUser.getCurrentUserId();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      }
    }
    return returnValue;
  }

  @Override
  public boolean onSave(Object entity, Serializable id, Object state[], String propertyNames[],
      Type types[]) {
    boolean returnValue = false;
    for (int i = 0; i < propertyNames.length; i++) {
      if ("insertTime".equals(propertyNames[i]) || "updateTime".equals(propertyNames[i])) {
        try {
          state[i] = currentUserLocalTime();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      } else if ("insertTimestamp".equals(propertyNames[i])
          || "updateTimestamp".equals(propertyNames[i])) {
        try {
          state[i] = currentTimestamp();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      } else if ("recorderId".equals(propertyNames[i]) || "insertedBy".equals(propertyNames[i])
          || "updaterId".equals(propertyNames[i]) || "updatedBy".equals(propertyNames[i])) {
        try {
          state[i] = TenancyContext.getTenancy().getTenantUserId();//appUser.getCurrentUserId();
        } catch (Exception ex) {
          logger.warn(ex.getMessage());
        }
        returnValue = true;
      }
    }
    return returnValue;
  }

}
