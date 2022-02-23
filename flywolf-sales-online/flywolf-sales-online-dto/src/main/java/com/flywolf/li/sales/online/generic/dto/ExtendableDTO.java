package com.flywolf.li.sales.online.generic.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class ExtendableDTO implements IExtendableDTO, Serializable {

  private static final long serialVersionUID = 1L;
  private Map<String, String> extendedProps = new HashMap<String, String>();
  private String serializedExtensionObj;

}
