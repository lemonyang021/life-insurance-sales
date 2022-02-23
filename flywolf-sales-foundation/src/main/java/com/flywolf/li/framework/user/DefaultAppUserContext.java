package com.flywolf.li.framework.user;

import java.util.Date;

import com.flywolf.li.framework.tenant.TenantClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultAppUserContext  implements AppUserContext {
  private static ThreadLocal<Long> localUserId = new ThreadLocal<>();

  @Autowired
  private TenantClient tenantClient;

  @Override
  public void setCurrentUserIdByTenantCode(String tenantCode) {
    setCurrentUserId(tenantClient.getUserId(tenantCode));
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ebao.li.framework.user.IAppUserContext#setCurrentUserId(java.lang.Long)
   */
  @Override
  public void setCurrentUserId(Long userId) {
    if (userId != null) {
      localUserId.set(userId);
    } else {
      localUserId.remove();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ebao.li.framework.user.IAppUserContext#getCurrentUserId()
   */
  @Override
  public Long getCurrentUserId() {
    return localUserId.get();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ebao.li.framework.user.IAppUserContext#getCurrentUserLocalTime()
   */
  @Override
  public Date getCurrentUserLocalTime() {
    return new Date();
  }

}
