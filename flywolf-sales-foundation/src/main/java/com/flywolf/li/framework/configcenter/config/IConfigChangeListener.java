package com.flywolf.li.framework.configcenter.config;

import java.util.Collection;

import com.flywolf.li.framework.configcenter.event.ConfigChangeEvent;
import org.springframework.core.PriorityOrdered;


public interface IConfigChangeListener extends PriorityOrdered {
  void handle(Collection<ConfigChangeEvent> events) throws Exception;
}
