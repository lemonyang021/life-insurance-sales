package com.flywolf.li.framework.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public interface InternalServiceUtils {
  String internalServiceHeader();

  InternalServiceHeader fromHttpHeader(HttpServletRequest httpRequest);

  UUID traceIdFromHttpHeader(HttpServletRequest httpRequest) throws IOException;
}
