package com.flywolf.li.framework.configcenter.config;

public interface IPlatformConst {
  /**
   * 用于精确指定lb的请求节点的 request header 参数 此参数用于接收一个ip或者ip:port 如果存在多个node,采用逗号分隔
   */
  String X_EBAO_LB_NODES = "X-ebao-lb-nodes";

  /**
   * 平台级别常量,用于服务间传递的标识,不同于token,这是内部标识,是内部的实现机制, 而token是外围系统向平台传递而使用,需要暴露到外网和外部用户,即便他们的值是相同的.
   * 内部header头总是应该采用X-ebao来作为前缀
   */
  String X_EBAO_USER_IDENTITY = "X-ebao-user-identity";

  /**
   * 外部系统向ebao内部系统传递租户标识时采用的header 名称
   */
  String HEADER_X_EBAO_TENANT_ID = "X-ebao-tenant-id";

  /**
   * 后台注册到网关的API版本采用的 header 名称
   */
  String HEADER_X_EBAO_VENDER_VERSION = "X-ebao-vender-version";

  /**
   * API注册者的租户代码使用的 header名称
   */
  String HEADER_X_EBAO_VENDOR_CODE = "X-ebao-vendor-code";

  /**
   * 
   * API的原始访问路径，带占位符
   */
  String HEADER_X_EBAO_ORIGIN_PATH = "x-ebao-origin-path";

  /**
   * 外部系统向ebao内部系统传递安全标识时采用的header 名称
   */
  String TOKEN = "token";

  /**
   * CORS 允许通过的HTTP头部字段集
   */
  String ACCESS_ALLOW_HEADERS = "Origin, X-Requested-With, Content-Type, Accept, Authorization,"
      + " _node_, X-ebao-tenant-id, X-ebao-vender-version, X-ebao-vendor-code, x-ebao-origin-path, session, "
      + "AG-Access-Key, AG-Signature, AG-Sign-Headers";
}
