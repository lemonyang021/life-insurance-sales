package com.flywolf.li.sales.config.channel.controller;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.service.ChannelConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@Tag(name = "渠道配置", description = "操作描述")
@RequestMapping(value = "/channel")
@Slf4j
public class ChannelConfigController {

    @Resource
    ChannelConfigService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "注册新渠道", description = "注册新渠道")
    public @ResponseBody
    Result<Long> register(@RequestBody @Validated RegisterChannelRequest request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        //log.info("hello lemon {},{}" + ResultCodeEnum.SUCCESS, request, request.getReqTime());
        return Result.success(service.register(request));
    }
}
