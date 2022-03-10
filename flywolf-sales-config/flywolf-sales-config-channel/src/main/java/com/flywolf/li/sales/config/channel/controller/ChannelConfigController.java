package com.flywolf.li.sales.config.channel.controller;

import com.flywolf.li.framework.dto.ClientServiceResponse;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@CrossOrigin
@RestController
@Tag(name = "渠道配置", description = "操作描述")
@RequestMapping(value = "/channel")
@Slf4j
public class ChannelConfigController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "注册新渠道", description = "注册新渠道")
    public @ResponseBody
    RegisterChannelResponse register(@RequestBody @Validated RegisterChannelRequest request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        log.info("hello lemon {},{}"+ClientServiceResponse.ServiceResultCode.SUCCEEDED, request, request.getClientRequestTime());
        RegisterChannelResponse response = new RegisterChannelResponse();
        response.setClientRequestId("1111");
        response.setServiceResTime(new Date());
        response.setResult(ClientServiceResponse.ServiceResultCode.SUCCEEDED);
        return response;
    }
}
