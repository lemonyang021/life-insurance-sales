package com.flywolf.li.framework.context;

import com.flywolf.li.framework.tenant.Tenancy;

public class TenancyContext {

  private TenancyContext() {
    throw new IllegalStateException("Utility class");
  }

  private static ThreadLocal<Tenancy> localTenancy = new ThreadLocal<>();

  public static void setTenancy(Tenancy tenancy) {
    localTenancy.set(tenancy);
  }

  public static Tenancy getTenancy() {
    return localTenancy.get();
  }

  public static void reset() {
    localTenancy.remove();
  }
}
