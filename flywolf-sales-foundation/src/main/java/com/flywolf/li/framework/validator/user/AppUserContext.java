package com.flywolf.li.framework.validator.user;

import java.util.Date;


public interface AppUserContext {

  void setCurrentUserId(Long userId);

  Long getCurrentUserId();

  Date getCurrentUserLocalTime();

}
