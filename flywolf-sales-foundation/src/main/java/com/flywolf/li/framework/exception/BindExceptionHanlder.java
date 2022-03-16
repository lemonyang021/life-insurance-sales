package com.flywolf.li.framework.exception;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.dto.ResultCodeEnum;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BindExceptionHanlder {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BindExceptionHanlder.class);

    @ExceptionHandler(BindException.class)
    public Result handleBindException(HttpServletRequest request, Exception exception) {
        if (exception instanceof BindException) {
            for (ObjectError error : ((BindException) exception).getAllErrors()) {
                return Result.error(error.getCode(), error.getDefaultMessage());
            }
        }
        return Result.error(ResultCodeEnum.SYS_ERROR.getCode(), exception.getMessage());
    }


}

