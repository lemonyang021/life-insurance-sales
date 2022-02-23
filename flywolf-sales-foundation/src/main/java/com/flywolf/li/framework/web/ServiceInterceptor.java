package com.flywolf.li.framework.web;

import com.ebao.li.flywolf.sales.dto.generic.GenericLiRequest;
import com.ebao.li.flywolf.sales.dto.generic.GenericLiResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ServiceInterceptor {
  String TenantCodeKey = "X-ebao-tenant-id";
  String FirstEndPointKey = "X-ebao-first-endpoint";
  String TenantUserId = "X-ebao-tenant-userId";
  
  String UNAUTHORIZED_REQUEST = "Unauthorized Request";
  String TenantNotNull = "X-ebao-tenant-id.notnull";
  String TenantNotMatch = "X-ebao-tenant-id.notmactch";

  ServiceHeader parseHeader(HttpServletRequest request, HttpServletResponse response);

  String parseBearerHeader(HttpServletRequest httpRequest, HttpServletResponse httpResponse);
}
