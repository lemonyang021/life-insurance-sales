package com.flywolf.li.sales.config.channel.controller;

import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@Tag(name = "渠道配置",description = "操作描述")
@RequestMapping(value = "/channel")
public class ChannelConfigController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ChannelConfigController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "注册新渠道",
            description = "注册新渠道", method = "POST")
    public @ResponseBody RegisterChannelResponse register(
            @RequestBody @Validated RegisterChannelRequest request, HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
        logger.info("hello lemon {}", request);
        RegisterChannelResponse response=new RegisterChannelResponse();

        return response;
    }
}
