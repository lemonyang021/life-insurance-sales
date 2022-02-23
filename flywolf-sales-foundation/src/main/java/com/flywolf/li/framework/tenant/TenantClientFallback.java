package com.flywolf.li.framework.tenant;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.flywolf.li.framework.exception.ConnectTimeoutException;

// @Component
public class TenantClientFallback implements TenantClient {
  private static final Logger logger = LoggerFactory.getLogger(TenantClientFallback.class);
  private static final Tenancy GUEST =
      new Tenancy("GUEST", "eBaoTech", "eBaoTech", "eBaoTech", "eBaoTech", 401L,1L);

  @Override
  public Long getUserId(String tenantCode) {
    logger.warn("tenant service is not ready, return 0 as default!");
    return 0L;
  }

  @Override
  public Tenancy get(String tenantCode) {
    if ("GUEST".equals(tenantCode)) {
      logger.warn("use mock tenant GUEST just for testing!");
      return GUEST;
    }
    throw new ConnectTimeoutException(TENANT_SERVICE);
  }

  public List<Tenancy> findByInsurerId(@RequestParam(value = "insurerId") Long insurerId) {
    return Collections.emptyList();
  }

}
