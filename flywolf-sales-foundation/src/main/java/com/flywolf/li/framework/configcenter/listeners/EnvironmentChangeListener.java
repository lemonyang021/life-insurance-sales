package com.flywolf.li.framework.configcenter.listeners;

import java.util.Collection;

import com.flywolf.li.framework.configcenter.ConfigurationLoader;
import com.flywolf.li.framework.configcenter.config.EChangeType;
import com.flywolf.li.framework.configcenter.config.IConfigChangeListener;
import com.flywolf.li.framework.configcenter.event.ConfigChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

/**
 * 修改环境变量
 * 
 * @author shawn.yang
 *
 */
public class EnvironmentChangeListener implements IConfigChangeListener {

  @Autowired
  private ConfigurableEnvironment environment = null;

  @Override
  public int getOrder() {
    return Ordered.HIGHEST_PRECEDENCE;
  }

  @Override
  public void handle(Collection<ConfigChangeEvent> events) {
    MapPropertySource configCenter =
        (MapPropertySource) environment.getPropertySources().get(ConfigurationLoader.CONFIGCENTER);
    for (ConfigChangeEvent event : events) {
      if (event.getType().equals(EChangeType.change)) {
        configCenter.getSource().put(event.getKey(), event.getValue());
      } else if (event.getType().equals(EChangeType.remove)) {
        configCenter.getSource().remove(event.getKey());
      } else if (event.getType().equals(EChangeType.add)) {
        configCenter.getSource().put(event.getKey(), event.getValue());
      }
    }
  }

}
