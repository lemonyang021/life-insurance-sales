package com.flywolf.li.sales.dou.controller;

import com.flywolf.li.framework.dto.Page;
import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.dou.dto.DouResponse;
import com.flywolf.li.sales.dou.dto.RegisterDouRequest;
import com.flywolf.li.sales.dou.dto.UpdateDouRequest;
import com.flywolf.li.sales.dou.service.DouService;
import com.flywolf.li.sales.dou.service.bo.DouBO;
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
@Tag(name = "分销组织管理", description = "操作描述")
@RequestMapping(value = "/dou")
@Slf4j
public class DouController {

    @Resource
    DouService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Operation(summary = "创建分销组织", description = "创建分销组织")
    public @ResponseBody
    Result<Long> create(@RequestBody @Validated RegisterDouRequest request) {
        DouBO bo = ConvertUtil.convert(request, DouBO.class);
        Long douId = service.register(bo);
        return Result.success(douId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Operation(summary = "更新分销组织", description = "更新分销组织")
    public @ResponseBody
    Result<Long> update(@RequestBody @Validated UpdateDouRequest request) {
        DouBO bo = ConvertUtil.convert(request, DouBO.class);
        service.update(bo);
        return Result.success();
    }

    @RequestMapping(value = "/{douid}/delete", method = RequestMethod.POST)
    @Operation(summary = "删除分销组织", description = "删除分销组织")
    public @ResponseBody
    Result<Long> delete(@PathVariable("douid") @Schema(title = "分销组织id") @NotBlank(message = "分销组织id不能为空") @NotNull(message = "分销组织id不能为空") Long douid) {
        log.info("delete douid = {}", douid);
        service.delete(douid);
        return Result.success();
    }

    @RequestMapping(value = "/{douid}", method = RequestMethod.GET)
    @Operation(summary = "获取分销组织信息", description = "获取分销组织信息")
    public @ResponseBody
    Result<DouResponse> get(@PathVariable("douid") @Schema(title = "分销组织id") @NotBlank(message = "分销组织id不能为空") @NotNull(message = "分销组织id不能为空") Long douid) {
        log.info("find by douid = {}", douid);
        DouResponse dou = ConvertUtil.convert(service.findById(douid), DouResponse.class);
        return Result.success(dou);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "获取所有分销组织信息", description = "获取所有分销组织信息")
    public @ResponseBody
    Result<Page<DouResponse>> list() {
        List<DouBO> douBOList = service.findAll();
        return Result.success(Page.listToPage(ConvertUtil.convert(douBOList, DouResponse.class)));
    }

}
