package com.flywolf.li.sales.channel.controller;


import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelCategoryRequest;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelRequest;
import com.flywolf.li.sales.channel.service.ChannelCategoryService;
import com.flywolf.li.sales.channel.service.bo.ChannelCategoryBO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Tag(name = "渠道种类管理", description = "操作描述")
@RequestMapping(value = "/channel/category")
@Slf4j
public class ChannelCategoryController {
    @Resource
    ChannelCategoryService channelCategoryService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "创建新渠道种类", description = "创建新渠道种类")
    public @ResponseBody
    Result<Long> register(@RequestBody @Validated RegisterChannelCategoryRequest request) {
        log.info("register channel category {}", request);
        ChannelCategoryBO channelCategoryBO = ConvertUtil.convert(request, ChannelCategoryBO.class);
        Long id = channelCategoryService.register(channelCategoryBO);
        return Result.success(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Operation(summary = "更新渠道种类", description = "更新渠道种类")
    public @ResponseBody
    Result<Long> update(@RequestBody @Validated RegisterChannelRequest request) {
        log.info("register channel category {}", request);
        ChannelCategoryBO channelCategoryBO = ConvertUtil.convert(request, ChannelCategoryBO.class);
        Long id = channelCategoryService.register(channelCategoryBO);
        return Result.success(id);
    }
}
