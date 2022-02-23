package com.flywolf.li.sales.online.generic.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

public interface IExtendableDTO extends java.io.Serializable{

    @ApiModelProperty(value = "扩展信息，Map类型，Key/Value都是字符型", position = 999)
    Map<String, String> getExtendedProps();

    void setExtendedProps(Map<String, String> extendedProps);

    @ApiModelProperty(hidden = true)
    String getSerializedExtensionObj();

    void setSerializedExtensionObj(String serializedExtensionObj);
}
