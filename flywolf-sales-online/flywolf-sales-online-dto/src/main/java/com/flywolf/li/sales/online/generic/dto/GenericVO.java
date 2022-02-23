package com.flywolf.li.sales.online.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericVO implements Serializable, Cloneable, GenericValueObject {

  private static final long serialVersionUID = 5877651171436098110L;

  private GenericVO extObject;

  private Map<String, String> extendedProps = new HashMap<String, String>();

  @Override
  public GenericVO clone() {
    try {
      GenericVO clonedObject = (GenericVO) super.clone();
      if (extObject != null) {
        clonedObject.setExtObject(extObject.clone());
      }
      return clonedObject;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }
}
