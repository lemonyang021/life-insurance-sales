package com.flywolf.li.framework.configcenter.http;

public enum EDiscoveryMode {
  /**
   * ip 模式,此模式下,注册信息为ip+port,负载均衡使用ip+port来完成
   */
  ip,
  /**
   * 此模式下,注册信息为application name, 端口固定为80, 这样,在任意的服务内，其依赖的服务均至多只有一个节点
   */
  dns
}
