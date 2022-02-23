package com.flywolf.li.framework.configcenter.client;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * 负责选择一个配置服务器
 * 
 * @author shawn.yang
 *
 */
public class ConfigServerReader {
  private Logger logger = LoggerFactory.getLogger(ConfigServerReader.class);

  public static final String LOCAL = "http://localhost:7101";

  public static final String CONFIG_CENTER_USERNAME = "ebao.config.center.username";
  public static final String CONFIG_CENTER_PASSWORD = "ebao.config.center.password";

  private Set<Node> serverNodes = new HashSet<>();
  private RestTemplate restTemplate = null;

  /**
   * 最大重试次数
   */
  private int maxRetry = 3;
  /**
   * 重试间隔
   */
  private int pingInteral = 8;

  private String service = "/configs";

  private String username = null;
  private String password = null;

  private List<ConfigReadCallback> callbacks = new ArrayList<>();

  public ConfigServerReader() {
    this(LOCAL);
  }

  /**
   * 多个url采用逗号分隔
   * 
   * @param urls
   */
  public ConfigServerReader(String urls) {
    this((urls == null ? LOCAL : urls).split(","));
  }

  public ConfigServerReader(String[] urls) {
    int priority = 1;
    for (String url : urls) {
      Node node = new Node(url, priority++);
      serverNodes.add(node);
    }

    callbacks.add(new DecodeCallback());
  }

  public String toList() {
    return StringUtils.collectionToCommaDelimitedString(serverNodes);
  }

  /**
   * 设置认证信息
   * 
   * @param username
   * @param password
   * @return
   */
  public ConfigServerReader auth(String username, String password) {
    this.username = username;
    this.password = password;
    return this;
  }

  /**
   * 考虑到使用此client的app启动时,config server还在启动之中,故而需要一个lazy&retry机制,来等待configserver加载完毕
   * 
   * @return
   */
  public Config read(String profile, String application, String label) {
    if (restTemplate == null) {
      restTemplate = new RestTemplate();
    }
    int tryTimes = 0;
    Config result = null;
    while (result == null && tryTimes < maxRetry) {
      logger.debug("try to get the config via {} at {} time ", toList(), tryTimes + 1);
      result = doRead(profile, application, label);
      if (result != null) {
        logger.debug("success get the config via path /{}/{}/{}", result.getProfile(),
            result.getApplication(), result.getLabel());
        break;
      }
      tryTimes++;
      logger.warn("fail to get the config,try after {} seconds", pingInteral);
      try {
        Thread.sleep(pingInteral * 1_000L);
      } catch (InterruptedException e) {
        logger.error("InterruptedException", e);
        Thread.currentThread().interrupt();
      }
    }

    if (result == null) {
      throw new RuntimeException("can not detect the config server via " + toList()
          + ",pls check you config and services");
    }

    enhance(result);
    return result;
  }

  /**
   * 解码支持
   * 
   * @param result
   */
  protected void enhance(Config result) {
    logger.debug("there are {} callback will be applyed!", callbacks.size());
    for (ConfigReadCallback callback : callbacks) {
      logger.debug("applying callback {}", callback.getClass().getName());
      callback.callback(result);
    }
  }

  protected Config doRead(String profile, String application, String label) {
    List<Node> orderedNodes = reorder(serverNodes);
    Config result = null;
    for (Node node : orderedNodes) {

      try {
        String url = concat(node.getUrl(), service) + "?profile={p}&application={a}&label={l}";
        ResponseEntity<Config> config = restTemplate.exchange(url, HttpMethod.GET,
            new HttpEntity<>(createHeaders(username, password)), Config.class, profile, application,
            label);
        result = config.getBody();
      } catch (Exception ex) {
        logger.error("error when getting config via server {}", node, ex);
      }

      if (result != null) {
        break;
      }
    }

    return result;
  }

  private String concat(String baseUrl, String shortUrl) {
    StringBuilder buffer = new StringBuilder();
    if (baseUrl.endsWith("/")) {
      buffer.append(baseUrl.substring(0, baseUrl.length() - 1));
    } else {
      buffer.append(baseUrl);
    }

    if (shortUrl.startsWith("/")) {
      buffer.append(shortUrl);
    } else {
      buffer.append("/").append(shortUrl);
    }
    return buffer.toString();
  }

  protected List<Node> reorder(Set<Node> nodes) {
    List<Node> result = new ArrayList<>(nodes);
    Collections.sort(result);
    return result;
  }

  /**
   * 产生 basic认证需要的header 此处要求配置的密码都已经是加密过的密码(采用用户名称作为salt)然后md5
   * 
   * @param username
   * @param password
   * @return
   */
  protected HttpHeaders createHeaders(String username, String password) {
    return new HttpHeaders() {
      private static final long serialVersionUID = 1L;
      {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.US_ASCII));
        String authHeader = "Basic " + new String(encodedAuth);
        set("Authorization", authHeader);
      }
    };
  }

  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Set<Node> getServerNodes() {
    return serverNodes;
  }

  public void setServerNodes(Set<Node> serverNodes) {
    this.serverNodes = serverNodes;
  }

  public int getMaxRetry() {
    return maxRetry;
  }

  public void setMaxRetry(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  public int getPingInteral() {
    return pingInteral;
  }

  public void setPingInteral(int pingInteral) {
    this.pingInteral = pingInteral;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public ConfigServerReader add(ConfigReadCallback callback) {
    this.callbacks.add(callback);
    return this;
  }
}
