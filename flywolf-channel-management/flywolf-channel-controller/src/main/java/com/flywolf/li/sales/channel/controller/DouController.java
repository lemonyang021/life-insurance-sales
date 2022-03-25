package com.flywolf.li.sales.channel.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Tag(name = "分销组织管理", description = "操作描述")
@RequestMapping(value = "/dou")
@Slf4j
public class DouController {
}
