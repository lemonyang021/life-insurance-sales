package com.flywolf.li.framework.web;

import com.flywolf.li.framework.context.ExtensionContext;
import com.flywolf.li.framework.context.TenancyContext;
import com.flywolf.li.framework.security.OauthProfile;
import com.flywolf.li.framework.tenant.Tenancy;
import com.flywolf.li.framework.tenant.TenantClient;
import com.flywolf.li.framework.user.AppUserContext;
import com.flywolf.li.pub.LogUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultServiceInterceptor implements ServiceInterceptor {
    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(DefaultServiceInterceptor.class);

    @Autowired
    private AppUserContext appUserContext;

    @Autowired
    private TenantClient tenantClient;

    @Autowired
    private LogUtils logUtils;

    private static final RestTemplate restTemplate = new RestTemplate();

    private String oauthUri;

    @Override
    public ServiceHeader parseHeader(HttpServletRequest request, HttpServletResponse response) {
        //从请求头获取租户编号
        String tenantCode = request.getHeader(TenantCodeKey);
        Tenancy tenancy = TenancyContext.getTenancy();
        if (tenancy == null) {
            tenancy = tenantClient.get(tenantCode);
            // add tenant info to tenancy context
            TenancyContext.setTenancy(tenancy);
        }
        ServiceHeader header = new ServiceHeader();
        header.setBrokerCode(tenancy.getBrokerCode());
        header.setChannelCode(tenancy.getChannelCode());
        header.setContractorCode(tenancy.getContractorCode());
        header.setXtenantId(tenancy.getXtenantId());

        appUserContext.setCurrentUserId(tenancy.getTenantUserId());
        // do some dirty work
        //
        Map<String, String> dirtyWork = new HashMap<>();
        dirtyWork.put(FirstEndPointKey, request.getHeader(FirstEndPointKey));
        ExtensionContext.setForwardHeaders(dirtyWork);
        return header;
    }

    public String parseBearerHeader(HttpServletRequest httpRequest,
                                    HttpServletResponse httpResponse) {
        String auth = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
        Assert.notNull(auth, UNAUTHORIZED_REQUEST);
        //
        Assert.isTrue(org.apache.commons.lang.StringUtils.isNotBlank(oauthUri), UNAUTHORIZED_REQUEST);
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, auth);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        try {
            RequestEntity<?> entity = new RequestEntity<>(headers, HttpMethod.GET, new URI(oauthUri));
            OauthProfile profile = restTemplate.exchange(entity, OauthProfile.class).getBody();
            Assert.isTrue(profile != null && profile.getId() != null, UNAUTHORIZED_REQUEST);
            return profile.getId();
        } catch (URISyntaxException e) {
            logger.error("", e);
        }
        return null;
    }

}