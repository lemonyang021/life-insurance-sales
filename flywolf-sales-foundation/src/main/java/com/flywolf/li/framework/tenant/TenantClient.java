package com.flywolf.li.framework.tenant;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = TenantClient.TENANT_SERVICE, path = "tenant",
    fallback = TenantClientFallback.class, configuration = TenantClientConfiguration.class)
public interface TenantClient extends InsurerTenantClient {

  public static final String TENANT_SERVICE = "tenantservice";

  @RequestMapping(value = "/tenants/{tenantCode}/user", method = RequestMethod.GET)
  @Cacheable("TenantClient.getUserId")
  public Long getUserId(@PathVariable("tenantCode") String tenantCode);

  @RequestMapping(value = "/tenants/{tenantCode}", method = RequestMethod.GET)
  @Cacheable("TenantClient.getTenancy")
  public Tenancy get(@PathVariable("tenantCode") String tenantCode);

  // @RequestMapping(value = "/tenants", method = RequestMethod.GET)
  // @Cacheable("TenantClient.list")
  // public Iterable<Tenancy> list();

  @Override
  @RequestMapping(value = "/tenants", method = RequestMethod.GET)
  @Cacheable("TenantClient.findByInsurerId")
  public List<Tenancy> findByInsurerId(@RequestParam(value = "insurerId") Long insurerId);
}
