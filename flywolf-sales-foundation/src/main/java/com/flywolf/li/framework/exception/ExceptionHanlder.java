package com.flywolf.li.framework.exception;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.dto.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionHanlder {

    @ExceptionHandler(Exception.class)
    public Result handleBindException(HttpServletRequest request, Exception exception) {
        if (exception instanceof BindException) {
            for (ObjectError error : ((BindException) exception).getAllErrors()) {
                return Result.error(ResultCodeEnum.SYS_ERROR.getCode(), error.getDefaultMessage());
            }
        }
        return Result.error(ResultCodeEnum.SYS_ERROR.getCode(), exception.getMessage());
    }


}

