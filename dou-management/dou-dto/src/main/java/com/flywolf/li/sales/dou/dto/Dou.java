package com.flywolf.li.sales.dou.dto;

import com.flywolf.li.framework.dto.Response;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class Dou extends Response {
    private static final long serialVersionUID = 1539677671153378673L;

    @Schema(title = "分销组织名称", required = true)
    @NotNull(message = "分销组织名称不能为空")
    @NotBlank(message = "分销组织名称不能为空")
    private String name;
    @NotNull(message = "分销组织代号不能为空")
    @NotBlank(message = "分销组织代号不能为空")
    @Schema(title = "分销组织代号", required = true)
    private String code;
    @NotNull(message = "分销组织联系人不能为空")
    @NotBlank(message = "分销组织联系人不能为空")
    @Schema(title = "分销组织联系人", required = true)
    private String contactPerson;

    @Schema(title = "分销组织联系人电话", required = true)
    private String contactPhone;

    @NotNull(message = "分销组织负责人不能为空")
    @NotBlank(message = "分销组织负责人不能为空")
    @Schema(title = "分销组织负责人", required = true)
    private String leader;
    @NotNull(message = "生效时间不能为空")
    @NotBlank(message = "生效时间不能为空")
    @Schema(title = "生效时间", required = true)
    private Date effectiveDate;
    @Schema(title = "终止时间", required = true)
    private Date endDate;
    @Schema(title = "终止原因", required = true)
    private Integer endReason;
}
