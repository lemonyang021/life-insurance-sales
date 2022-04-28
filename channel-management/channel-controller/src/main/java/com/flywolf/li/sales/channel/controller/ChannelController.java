package com.flywolf.li.sales.channel.controller;

import com.flywolf.li.framework.dto.Page;
import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.dto.req.QueryChannelRequest;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelRequest;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import com.flywolf.li.sales.channel.dto.resp.QueryChannelResponse;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.service.bo.ChannelBO;
import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;
import com.flywolf.li.sales.channel.service.bo.QueryBO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author flywolf
 */
@CrossOrigin
@RestController
@Tag(name = "渠道管理", description = "操作描述")
@RequestMapping(value = "/channel")
@Slf4j

public class ChannelController {

    @Resource
    ChannelService service;

    @PostMapping(value = "/register")
    @Operation(summary = "注册新渠道", description = "注册新渠道")
    public @ResponseBody
    Result<Long> register(@RequestBody @Validated RegisterChannelRequest request) {
        log.info("register channel {}", request);
        ChannelBO channelBO = ConvertUtil.convert(request, ChannelBO.class);
        channelBO.setChannelCategoryBO(ConvertUtil.convert(request, ChannelCategoryBO.class));
        Long channelId = service.register(channelBO);
        return Result.success(channelId);
    }

    @PostMapping(value = "/update")
    @Operation(summary = "更新渠道", description = "更新渠道")
    public @ResponseBody
    Result update(@RequestBody @Validated RegisterChannelRequest request) {
        log.info("update channel {}", request);
        service.update(ConvertUtil.convert(request, ChannelBO.class));
        return Result.success();
    }

    @GetMapping(value = "/{channelId}")
    @Operation(summary = "获取渠道信息", description = "通过渠道id获取渠道信息")
    public @ResponseBody
    Result<QueryChannelResponse> get(@PathVariable("channelId") @Schema(title = "渠道id") @NotBlank(message = "渠道id不能为空") @NotNull(message = "渠道id不能为空") Long channelId) {
        log.info("get channel by id {}", channelId);
        return Result.success(ConvertUtil.convert(service.get(channelId), QueryChannelResponse.class));
    }

    @PostMapping(value = "/query")
    @Operation(summary = "获取渠道信息", description = "通过条件获取渠道信息")
    public @ResponseBody
    Result<Page<QueryChannelResponse>> query(@RequestBody @Validated QueryChannelRequest request) {
        log.info("query channel {}", request);
        //转换请求对象为查询业务对象
        QueryBO queryBO = ConvertUtil.convert(request, QueryBO.class);
        //调用查询服务
        List<ChannelBO> boList = service.query(queryBO);
        //转换查询结果对象为返回对象
        List<QueryChannelResponse> queryChannelResponseList = ConvertUtil.convert(boList, QueryChannelResponse.class);
        //返回查询结果
        return Result.success(Page.listToPage(queryChannelResponseList));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "获取所有渠道信息", description = "获取所有渠道信息")
    public @ResponseBody
    Result<Page<ChannelResponse>> get() {
        log.info("get all channel");
        List<ChannelBO> channelBOList = service.findAll();
        return Result.success(Page.listToPage(ConvertUtil.convert(channelBOList, ChannelResponse.class)));
    }
}
