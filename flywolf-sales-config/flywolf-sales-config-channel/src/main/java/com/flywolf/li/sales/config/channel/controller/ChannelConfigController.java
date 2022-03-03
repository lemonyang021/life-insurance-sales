package com.flywolf.li.sales.config.channel.controller;

import com.flywolf.li.sales.config.channel.dto.RegisterChannelRequest;
import com.flywolf.li.sales.config.channel.dto.RegisterChannelResponse;
import io.swagger.annotations.*;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@Api(tags = "1111")
@RequestMapping(value = "/channel")
public class ChannelConfigController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ChannelConfigController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册新渠道",
            notes = "2222", httpMethod = "POST",
            response = RegisterChannelResponse.class)
    public RegisterChannelResponse register(
            @RequestBody RegisterChannelRequest request, HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
        logger.info("hello lemon {}", request);
        return null;
    }
}
