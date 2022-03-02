package com.flywolf.li.sales.online.server.filter;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenantFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(TenantFilter.class);

    @Autowired
    Environment env;

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";
    public static final String DEFAULT_TIME_ZONE = "Asia/Shanghai";
    private static final String DOT_STRING = ".";
    private static final String TENANT_USER_ID_PROPERTY_NAME = "tenantUserId";
    private static final String TENANT_DATE_FORMART_PROPERTY_NAME = "dateFormat";
    private static final String TENANT_DEFAULT_TIME_ZONE_PROPERTY_NAME = "defaultTimeZone";

    @Override
    public void destroy() {
        // Do nothing
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                 FilterChain filterChain) throws IOException, ServletException {
        try {
      /*String tenantCode = request.getHeader(ServiceInterceptor.TenantCodeKey);
      if (StringUtils.isEmpty(tenantCode)) {
        tenantCode="ebao";
      }
      String auth = request.getHeader("Authorization");
      if (StringUtils.isNotBlank(tenantCode)) {
        Tenancy tenancy = new Tenancy();
        tenancy.setXtenantId(tenantCode);
        tenancy.setBrokerCode(tenantCode);
        tenancy.setChannelCode(tenantCode);
        tenancy.setContractorCode(tenantCode);
        String userIdProperty ="";
//            TargetServiceProvider.mo.type().concat(DOT_STRING).concat(tenantCode.toLowerCase())
//                .concat(DOT_STRING).concat(TENANT_USER_ID_PROPERTY_NAME);
        String tenantUserId = env.getProperty(userIdProperty, "401");
        tenancy.setTenantUserId(Long.valueOf(tenantUserId));
        String dateFormatProperty ="";
//            TargetServiceProvider.mo.type().concat(DOT_STRING).concat(tenantCode.toLowerCase())
//                .concat(DOT_STRING).concat(TENANT_DATE_FORMART_PROPERTY_NAME);
        tenancy.setDateFormat(env.getProperty(dateFormatProperty, DATE_FORMAT));
        String timeZoneProperty ="";
//            TargetServiceProvider.mo.type().concat(DOT_STRING).concat(tenantCode.toLowerCase())
//                .concat(DOT_STRING).concat(TENANT_DEFAULT_TIME_ZONE_PROPERTY_NAME);
        tenancy.setDefaultTimeZone(env.getProperty(timeZoneProperty, DEFAULT_TIME_ZONE));
        tenancy.setCurrentUserLocalTime(new Date());
        TenancyContext.setTenancy(tenancy);

      }*/
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
            } else {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
//      TenancyContext.reset();
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
}
