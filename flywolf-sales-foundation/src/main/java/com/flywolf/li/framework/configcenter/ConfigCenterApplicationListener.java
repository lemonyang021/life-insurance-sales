package com.flywolf.li.framework.configcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.flywolf.li.framework.configcenter.config.IConfigLoadCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.Assert;


/**
 * 应用监听器,当应用启动时,负责解析应用的配置信息,并完成信息的加载
 * 
 * @author shawn.yang
 *
 */
public class ConfigCenterApplicationListener
    implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {
  private Logger logger = LoggerFactory.getLogger(ConfigCenterApplicationListener.class);
  private  MapPropertySource propertySource = null;

  private ConfigurationLoader loader = new ConfigurationLoader();

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

    String enabled = event.getEnvironment().resolvePlaceholders("${ebao.config.center.enabled}");
    if (!"TRUE".equalsIgnoreCase(enabled)) {
      logger.info("config center is disabled!");
      return;
    }
    
    String application = event.getEnvironment().resolvePlaceholders("${spring.application.name}");
    Assert.hasLength(application, "you must config a propertie name spring.application.name");
    if (propertySource != null) {
      event.getEnvironment().getPropertySources()
          .addAfter(RandomValuePropertySource.RANDOM_PROPERTY_SOURCE_NAME, propertySource);
      return;
    }
    Environment environment = event.getEnvironment();


    List<IConfigLoadCallback> configloadCallbacks = findConfigloadCallbacks();



    fireBeforeload(configloadCallbacks, event.getEnvironment());


    ConfigurationLoadResult result = loader.load(environment);
    logger.info("success find the config from configcenter via {}/{}/{},and fetch {} config items",
        result.getProfile(), result.getApplication(), result.getProfile(),
        result.getSource().getSource().size());

    propertySource = result.getSource();
    String[] params = new String[] {result.getUrls(), result.getProfile(), result.getApplication(),
        result.getLabel()};
    fireBeforeAdd(configloadCallbacks, event.getEnvironment(), propertySource, params);
    Object profiles = propertySource.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
    if (profiles != null) {
      System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, (String) profiles);
    }
    // https://oss.ebaotech.com/ebaocloud/platform-starters/issues/1
    event.getEnvironment().getPropertySources()
        .addAfter(RandomValuePropertySource.RANDOM_PROPERTY_SOURCE_NAME, propertySource);

    fireAfterAdd(configloadCallbacks, event.getEnvironment(), propertySource, params);
  }

  private void fireAfterAdd(List<IConfigLoadCallback> configloadCallbacks,
      ConfigurableEnvironment environment, MapPropertySource propertySource, String[] params) {
    for (IConfigLoadCallback callback : configloadCallbacks) {
      callback.afterAdd(environment, propertySource, params);
    }
  }

  private void fireBeforeAdd(List<IConfigLoadCallback> configloadCallbacks,
      ConfigurableEnvironment environment, MapPropertySource propertySource, String[] params) {
    for (IConfigLoadCallback callback : configloadCallbacks) {
      callback.beforeAdd(environment, propertySource, params);
    }

  }

  private void fireBeforeload(List<IConfigLoadCallback> configloadCallbacks,
      ConfigurableEnvironment environment) {
    for (IConfigLoadCallback callback : configloadCallbacks) {
      callback.beforeLoad(environment);
    }
  }

  /**
   * 获取IConfigLoadCallback 服务的实现
   * 
   * @return
   */
  protected List<IConfigLoadCallback> findConfigloadCallbacks() {
    List<IConfigLoadCallback> callbacks = new ArrayList<>();
    ServiceLoader<IConfigLoadCallback> serviceLoader =
        ServiceLoader.load(IConfigLoadCallback.class);
    for (IConfigLoadCallback service : serviceLoader) {
      callbacks.add(service);
    }
    return callbacks;
  }


}
