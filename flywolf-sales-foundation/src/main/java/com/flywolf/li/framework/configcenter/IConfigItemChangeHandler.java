package com.flywolf.li.framework.configcenter;

import java.util.Set;

public interface IConfigItemChangeHandler {
  /**
   * the support config key in current handler
   * 
   * @return
   */
  Set<String> support();

  /**
   * when update or add,this method will be called
   * 
   * @param key
   * @param value
   */
  void onUpdate(String key, String value);

  /**
   * when remove or clear,this method will be called
   * 
   * @param key
   * @param value
   */
  void onRemove(String key);

  /**
   * the value with lowest will have most high priority
   * 
   * @return
   */
  int order();
}
