package com.flywolf.li.framework.configcenter;

import java.util.HashMap;
import java.util.Map;

import com.flywolf.li.framework.configcenter.client.Config;
import com.flywolf.li.framework.configcenter.client.ConfigServerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public class ConfigurationLoader {
  private Logger logger = LoggerFactory.getLogger(ConfigurationLoader.class);

  public static final String CONFIGCENTER = "config.center";

  public static final String PORT = "application.instance.port";

  public static String CONFIG_CENTER_ENABLED = "ebao.config.center.enabled";
  public static String CONFIG_CENTER_URL = "ebao.config.center.url";


  public static String CONFIG_CENTER_PROFILE = "ebao.config.center.profile";
  public static String CONFIG_CENTER_PROFILE_DEAULT = "dev";

  public static String CONFIG_CENTER_LABEL = "ebao.config.center.label";
  public static String CONFIG_CENTER_LABEL_DEFAULT = "snapshot";

  public static String CONFIG_CENTER_USERNAME = "ebao.config.center.username";
  public static String CONFIG_CENTER_PASSWORD = "ebao.config.center.password";
  public static String Discovery_Mode = "platform.discovery.mode";
  public static String REGION = "platform.region";
  public static String PROVIDER = "platform.provider";
  public static String PLATFORM_SECURITY = "platform.security";

  private String CONFIG_LOCAL_CARETAKER_PORT = "caretaker.port"; // default 7000
  private String CONFIG_PUBLIC = "public";

  public String findProfile(Environment environment) {
    return environment.getProperty(CONFIG_CENTER_PROFILE, CONFIG_CENTER_PROFILE_DEAULT);
  }

  public String findLabel(Environment environment) {
    return environment.getProperty(CONFIG_CENTER_LABEL, CONFIG_CENTER_LABEL_DEFAULT);
  }

  public ConfigurationLoadResult load(Environment environment) {
    int careTakerPort = environment.getProperty(CONFIG_LOCAL_CARETAKER_PORT, Integer.class, 7000);
    /**
     * 先从caretaker获取配置信息
     */
    Map<String, Object> localVmConfig = loadConfigFromLocalVmCareTaker(careTakerPort);

    String urls =
        findConfig(CONFIG_CENTER_URL, localVmConfig, environment, "http://localhost:7101");

    String enabled = findConfig(CONFIG_CENTER_ENABLED, localVmConfig, environment, "true");
    Assert.isTrue("true".equalsIgnoreCase(enabled) || "false".equalsIgnoreCase(enabled),
        "invalid config value " + enabled + " for config item " + CONFIG_CENTER_ENABLED);

    String application = environment.resolvePlaceholders("${spring.application.name}");
    Assert.hasText(application,
        "application name is not configed,pls check the config in application.properties");

    String profile = findConfig(CONFIG_CENTER_PROFILE, localVmConfig, environment, "dev");

    String label = findConfig(CONFIG_CENTER_LABEL, localVmConfig, environment, "snapshot");


    String username = findConfig(CONFIG_CENTER_USERNAME, localVmConfig, environment, null);
    String password = findConfig(CONFIG_CENTER_PASSWORD, localVmConfig, environment, null);
    ConfigurationLoadResult loadResult = new ConfigurationLoadResult();
    loadResult.setSource(loadConfigConfigCenter(Boolean.valueOf(enabled), username, password, urls,
        profile, application, label));
    loadResult.setApplication(application);
    loadResult.setLabel(label);
    loadResult.setProfile(profile);
    loadResult.setUrls(urls);
    return loadResult;
  }

  /**
   * 优先从localVmConfig中得到配置,如果找不到,从当前环境配置集中加载
   * 
   * @param configItem
   * @param localVmConfig
   * @param event
   * @param defaultValue
   * @return
   */
  private String findConfig(String configItem, Map<String, Object> localVmConfig,
      Environment environment, String defaultValue) {
    String value = localVmConfig == null ? null : (String) localVmConfig.get(configItem);
    if (StringUtils.hasText(value)) {
      logger.debug("using {} from careTaker with value [{}] ", configItem, value);
    } else {
      value = environment.getProperty(configItem);
      if (StringUtils.hasText(value)) {
        logger.debug("using {} from application with value [{}]", configItem, value);

      } else {
        logger.debug("using {} from default value [{}]", configItem, defaultValue);
        return defaultValue;
      }
    }

    if (value != null) {
      value = value.trim();
    }
    return value;
  }

  /**
   * 从本地careTaker中获取信息,获取不到返回null
   * 
   * @param port
   * @return
   */
  protected Map<String, Object> loadConfigFromLocalVmCareTaker(int port) {
    // RestTemplate restTemplate=new RestTemplate();
    Map<String, Object> datas = new HashMap<>();
    String url = "http://localhost:" + port + "/system";
    try {
      // datas.putAll(restTemplate.getForObject(url,Map.class));
      return datas;
    } catch (Exception ex) {
      logger.error("can not access the caretaker from {}", url);
      return null;
    }

  }

  protected MapPropertySource loadConfigConfigCenter(boolean enabled, String username,
      String password, String urls, String profile, String application, String label) {
    if (enabled == false) {
      return new MapPropertySource(CONFIGCENTER, new HashMap<>());
    }

    ConfigServerReader configServerReader = new ConfigServerReader(urls);
    configServerReader.auth(username, password);
    /**
     * 先加载公共配置,在加载特性配置
     */
    Config baseConfig = configServerReader.read(profile, CONFIG_PUBLIC, label);

    Config config = configServerReader.read(profile, application, label);


    Map<String, Object> datas = new HashMap<>();
    datas.putAll(baseConfig.getData());
    datas.putAll(config.getData());

    MapPropertySource propertySource = new MapPropertySource(CONFIGCENTER, datas);

    return propertySource;

  }

  @SuppressWarnings("unchecked")
  public void reload(ConfigurableEnvironment environment, String applicationName,
      ConfigEvent configEvent) {
    if (!matched(environment, applicationName, configEvent)) {
      return;
    }

    logger.warn("config update with mode {}...", configEvent.getMode());
    PropertySource<?> propertySource = environment.getPropertySources().get(CONFIGCENTER);
    if (propertySource != null && configEvent.getMode() != null) {
      Map<String, Object> sourceDatas = (Map<String, Object>) propertySource.getSource();
      if (configEvent.isUpdate()) {
        for (String key : configEvent.getData().keySet()) {
          sourceDatas.put(key, configEvent.getData().get(key));
        }
      } else if (configEvent.isRemove()) {
        for (String key : configEvent.getData().keySet()) {
          sourceDatas.remove(key);
        }
      } else if (configEvent.isClear()) {
        sourceDatas.clear();
      }
    }
  }

  /**
   * 当且仅当 profile和label相同,application 为public或者相同时,才match
   * 
   * @param environment
   * @param applicationName
   * @param targetProfile
   * @param targetApplication
   * @param targetLabel
   * @return
   */
  private boolean matched(Environment environment, String currentAppName, ConfigEvent event) {
    String currentProfile = findProfile(environment);
    String currentLabel = findLabel(environment);
    /**
     * 必须保证profile和label是相同的
     */
    if (currentProfile != null && currentProfile.equals(event.getProfile()) && currentLabel != null
        && currentLabel.equals(event.getLabel())) {
      if (event.getApplication() != null && event.getApplication().equals(CONFIG_PUBLIC)) {
        return true;
      } else if (event.getApplication() != null && event.getApplication().equals(currentAppName)) {
        return true;
      } else {
        return false;
      }
    }

    // 其他任何case
    return false;
  }
}
