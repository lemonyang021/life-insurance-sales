package com.flywolf.li.framework.dto;



import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

public interface IExtendableDTO extends java.io.Serializable{

    @Schema(title = "扩展信息，Map类型，Key/Value都是字符型")
    Map<String, String> getExtendedProps();

    void setExtendedProps(Map<String, String> extendedProps);

    @Schema(hidden = true)
    String getSerializedExtensionObj();

    void setSerializedExtensionObj(String serializedExtensionObj);
}
