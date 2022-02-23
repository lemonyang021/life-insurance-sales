package com.flywolf.li.framework.user;

import java.util.Date;


public interface AppUserContext {

  void setCurrentUserIdByTenantCode(String tenantCode);

  void setCurrentUserId(Long userId);

  Long getCurrentUserId();

  Date getCurrentUserLocalTime();

}
