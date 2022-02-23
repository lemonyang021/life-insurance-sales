package com.flywolf.li.framework.configcenter.http;

import com.flywolf.li.framework.configcenter.config.IPlatformConst;
import com.flywolf.li.framework.configcenter.utils.UUIDUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Configuration
public class ServerInformation implements IPlatformConst, InitializingBean {
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

  public static final String eBao = "eBao";
  public static final String gateway = "gateway";

  @Autowired
  private Environment environment;

  private Version version = new Version(true);
  private IPidFinder pidFinder = new DefaultPidFinder();
  private IInetAddressFinder inetAddressFinder = new EnvAwareInetAddressFinder();

  private String instanceId = null;

  public ServerInformation() {
    instanceId = UUIDUtils.uuid16();
  }


  /**
   * 实例id
   * 
   * @return
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * 当前服务端口
   * 
   * @return
   */
  public int getPort() {
    String port = System.getProperty(PORT);
    if (StringUtils.hasLength(port)) {
      return Integer.valueOf(port);
    } else {
      return 0;
    }

  }

  /**
   * 应用名称
   * 
   * @return
   */
  public String getApplicationName() {
    return environment.getProperty("spring.application.name");
  }

  /**
   * 内网Ip地址
   * 
   * @return
   */
  public String getIp() {
    return inetAddressFinder.find();
  }

  /**
   * 进程id
   * 
   * @return
   */
  public int getPid() {
    return pidFinder.find();
  }

  public String getHostname() {
    return inetAddressFinder.hostname();
  }

  /**
   * 获取当前系统的版本信息,由于版本文件是构建release package 时自动生成并放到conf目录作为classpath下的一个资源文件, 故开发时无法得到真正的版本的信息.
   * 开发时的版本信息是dev-local-ver buildAt是当前时间系统启动的时间
   * 
   * @return
   */
  public Version getVersion() {
    return version;
  }

  public String getProfile() {
    return environment.getProperty(CONFIG_CENTER_PROFILE, CONFIG_CENTER_PROFILE_DEAULT);
  }

  public String getLabel() {
    return environment.getProperty(CONFIG_CENTER_LABEL, CONFIG_CENTER_LABEL_DEFAULT);
  }

  public EDiscoveryMode getDiscoveryMode() {
    String mode = environment.getProperty(Discovery_Mode, EDiscoveryMode.ip.name());
    return EDiscoveryMode.valueOf(mode);
  }

  /**
   * 获取系统分区信息,如果未配置,则使用profile代替
   * 
   * @return
   */
  public String getRegion() {
    return environment.getProperty(REGION, getProfile());
  }

  /**
   * 获取应用的提供者, 是租户code
   * 
   * @return
   */
  public String getApplicationProvider() {
    return environment.getProperty(PROVIDER, eBao);
  }

  /**
   * 该服务是否由平台执行安全控制,默认是true
   * 
   * @return
   */
  public boolean isSecurity() {
    return environment.getProperty(PLATFORM_SECURITY, Boolean.class, true);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Assert.notNull(getApplicationProvider(), "err_platform_provider_must_be_existed");

  }
}
