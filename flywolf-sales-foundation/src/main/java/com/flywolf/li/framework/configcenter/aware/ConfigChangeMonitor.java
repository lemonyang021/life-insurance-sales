package com.flywolf.li.framework.configcenter.aware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.flywolf.li.framework.configcenter.ConfigCenterProperties;
import com.flywolf.li.framework.configcenter.ConfigurationLoadResult;
import com.flywolf.li.framework.configcenter.ConfigurationLoader;
import com.flywolf.li.framework.configcenter.config.EChangeType;
import com.flywolf.li.framework.configcenter.config.IConfigChangeListener;
import com.flywolf.li.framework.configcenter.event.ConfigChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

public class ConfigChangeMonitor {

  private static Logger logger = LoggerFactory.getLogger(ConfigChangeMonitor.class);
  @Autowired
  private ConfigCenterProperties configCenterProperties = null;

  @Autowired(required = false)
  private List<IConfigChangeListener> configChangeListeners = null;

  private ConfigurationLoader loader = new ConfigurationLoader();

  @Autowired
  private ConfigurableEnvironment environment = null;

  @PostConstruct
  public void init() {
    // reorder listeners
    OrderComparator.sort(configChangeListeners);

    Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
      @Override
      public void run() {
        try {
          process();
        } catch (Exception ex) {
          logger.error("error when reload configcenter configs...", ex);
        }
      }

    }, configCenterProperties.getInitialDelay(), configCenterProperties.getDelay(),
        TimeUnit.SECONDS);
  }

  protected void process() throws Exception {
    ConfigurationLoadResult result = loader.load(environment);
    Collection<ConfigChangeEvent> events = doFilter(result.getSource());
    if (events.isEmpty()) {
      logger.debug("ingore change application configs as no diffenerce!");
      return;
    } else {
      onChanged(events);
    }
  }

  /**
   * @param events
   */
  protected void onChanged(Collection<ConfigChangeEvent> events) {
    for (IConfigChangeListener listener : configChangeListeners) {
      try {
        listener.handle(events);
      } catch (Exception ex) {
        logger.error("error when fire config change event", ex);
      }
    }
  }

  /**
   * check the latest config is same with current config
   * 
   * @param target
   * @return
   */
  private Collection<ConfigChangeEvent> doFilter(MapPropertySource latest) {
    MapPropertySource current =
        (MapPropertySource) environment.getPropertySources().get(ConfigurationLoader.CONFIGCENTER);
    Collection<ConfigChangeEvent> events = new ArrayList<>();

    Set<String> newNames = new HashSet<>();
    newNames.addAll(latest.getSource().keySet());
    for (String key : current.getPropertyNames()) {
      if (newNames.contains(key) == false) {
        // removed
        ConfigChangeEvent event = new ConfigChangeEvent();
        event.setKey(key);
        event.setType(EChangeType.remove);
        event.setValue(null);
        events.add(event);
        continue;
      }

      boolean isSame = latest.getProperty(key).equals(current.getProperty(key));

      // if not same the create a change event
      if (!isSame) {
        ConfigChangeEvent event = new ConfigChangeEvent();
        event.setKey(key);
        event.setType(EChangeType.change);
        event.setValue((String) latest.getProperty(key));
        events.add(event);
      }

      // remove the old config name,so i can know the added config according current config
      newNames.remove(key);
      continue;
    }

    for (String key : newNames) {
      ConfigChangeEvent event = new ConfigChangeEvent();
      event.setKey(key);
      event.setType(EChangeType.add);
      event.setValue((String) latest.getProperty(key));
      events.add(event);
    }

    return events;
  }

}
