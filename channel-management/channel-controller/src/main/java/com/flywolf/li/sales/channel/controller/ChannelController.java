package com.flywolf.li.sales.channel.controller;

import com.flywolf.li.framework.dto.Page;
import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelRequest;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import com.flywolf.li.sales.channel.dto.resp.QueryChannelResponse;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.service.bo.ChannelBO;
import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;
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
        log.info("register channel {}", request);
        ChannelBO ChannelBO = ConvertUtil.convert(request, ChannelBO.class);
        ChannelBO.setChannelCategoryBO(ConvertUtil.convert(request, ChannelCategoryBO.class));
        Long channelId = service.register(ChannelBO);
        return Result.success(channelId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Operation(summary = "更新渠道", description = "更新渠道")
    public @ResponseBody
    Result update(@RequestBody @Validated RegisterChannelRequest request) {
        log.info("update channel {}", request);
        service.update(ConvertUtil.convert(request, ChannelBO.class));
        return Result.success();
    }

    @RequestMapping(value = "/{channelId}", method = RequestMethod.GET)
    @Operation(summary = "获取渠道信息", description = "通过渠道id获取渠道信息")
    public @ResponseBody
    Result<QueryChannelResponse> get(@PathVariable("channelId") @Schema(title = "渠道id") @NotBlank(message = "渠道id不能为空") @NotNull(message = "渠道id不能为空") Long channelId) {
        log.info("get channel {}", channelId);
        return Result.success(ConvertUtil.convert(service.get(channelId), QueryChannelResponse.class));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @Operation(summary = "获取渠道信息", description = "通过条件获取渠道信息")
    public @ResponseBody
    Result<ChannelResponse> query(@PathVariable("channelId") @Schema(title = "渠道id") @NotBlank(message = "渠道id不能为空") @NotNull(message = "渠道id不能为空") Long channelId) {
        log.info("get channel {}", channelId);
        return Result.success(ConvertUtil.convert(service.get(channelId), ChannelResponse.class));
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
