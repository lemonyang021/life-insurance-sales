package com.flywolf.li.framework.tenant;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flywolf.li.framework.context.TenancyContext;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flywolf.li.framework.web.ServiceInterceptor;
import com.netflix.hystrix.exception.HystrixRuntimeException;

import feign.FeignException;

public class TenantFilterLimo extends OncePerRequestFilter {

  private static final Logger log = LoggerFactory.getLogger(TenantFilterLimo.class);

  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  private TenantClient tenantClient;

  @Override
  public void destroy() {
    // Do nothing
  }

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    try {
      String tenantCode = request.getHeader(ServiceInterceptor.TenantCodeKey);
      if (StringUtils.isNotBlank(tenantCode) && !isSkip()) {
        Tenancy tenancy = tenantClient.get(tenantCode);
        TenancyContext.setTenancy(tenancy);
      }
      filterChain.doFilter(request, response);
    } catch (HystrixRuntimeException e) {
      logRequest(request);
      Throwable cause = ExceptionUtils.getRootCause(e);
      if (cause instanceof FeignException) {
        FeignException fe = (FeignException) cause;
        response.setStatus(fe.status());
        String message = e.getCause().getMessage();
        int i = message.lastIndexOf("\n");
        message = i != -1 ? message.substring(i) : message;
        response.getWriter().write(message);
      }  else {
        throw e;
      }
    } finally {
      TenancyContext.reset();
    }
  }

  private void logRequest(HttpServletRequest request) {
    String url = request.getRequestURI();
    String remoteAddr = request.getHeader("X-FORWARDED-FOR");
    if (remoteAddr == null) {
      remoteAddr = request.getRemoteAddr();
    }
    log.info("{} accessed from {} failed", url, remoteAddr);
  }

  private boolean isSkip() {
    return TenantClient.TENANT_SERVICE.equalsIgnoreCase(applicationName);
  }
}
