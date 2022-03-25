package com.flywolf.li.sales.dou.dto;

import com.flywolf.li.framework.dto.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "分销组织更新请求",description = "分销组织更新请求")
public class UpdateDouRequest extends Request {
    private static final long serialVersionUID = -4319848633931252831L;
    @Schema(title = "分销组织id")
    @NotNull(message = "分销组织id不能为空")
    @NotBlank(message = "分销组织id不能为空")
    private Long id;
    @Schema(title = "分销组织名称", required = true)
    @NotNull(message = "分销组织名称不能为空")
    @NotBlank(message = "分销组织名称不能为空")
    private String douName;
    @NotNull(message = "分销组织代号不能为空")
    @NotBlank(message = "分销组织代号不能为空")
    @Schema(title = "分销组织代号", required = true)
    private String douCode;
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
