package com.flywolf.li.framework.log;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
@RestControllerAdvice
public class RequestAopLogComponent implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        JSONObject json = JSONUtil.parseObj(inputMessage, false, true);
        json.setDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("请求参数====>{}", json.toStringPretty());
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        RequestMapping requestMapping = parameter.getMethodAnnotation(RequestMapping.class);
        log.info("请求地址====>{}", StringUtils.arrayToDelimitedString(requestMapping.value(), ","));
        JSONObject json = JSONUtil.parseObj(body, false, true);
        json.setDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("请求参数====>{}", json.toStringPretty());
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
