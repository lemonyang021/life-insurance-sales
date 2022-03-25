package com.flywolf.li.sales.channel.controller;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.dto.ResultCodeEnum;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.dto.RegisterChannelRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Tag(name = "渠道管理", description = "操作描述")
@RequestMapping(value = "/channel")
@Slf4j
public class ChannelController {

    @Resource
    ChannelService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "注册新渠道", description = "注册新渠道")
    public @ResponseBody
    Result<Long> register(@RequestBody @Validated RegisterChannelRequest request) {
        log.info("hello lemon {},{}" + ResultCodeEnum.SUCCESS, request, request.getReqTime());
        Long channelId = service.register(request);
        service.update(request);
        return Result.success(channelId);
    }
}
