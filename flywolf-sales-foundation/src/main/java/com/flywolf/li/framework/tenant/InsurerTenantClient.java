package com.flywolf.li.framework.tenant;

import java.util.List;

public interface InsurerTenantClient {
  List<Tenancy> findByInsurerId(Long insurerId);
}
