package com.flywolf.li.framework.configcenter.client;

import java.security.interfaces.RSAPrivateKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.ebao.li.framework.configcenter.utils.RSAUtil;

/**
 * 解码支持,在classpath 下查询是否含有rsa.private的文件,如果不存在,则忽略解码 否者支持解码
 * 
 * @author shawn.yang
 *
 */
public class DecodeCallback implements ConfigReadCallback {
  private static Logger logger = LoggerFactory.getLogger(DecodeCallback.class);
  private static final String PREFIX = "rsa@";
  private static final String FILE_NAME = "rsa.private";

  RSAPrivateKey rsaPrivateKey = null;

  public DecodeCallback() {
//    InputStream inputStream = this.getClass().getResourceAsStream("/" + FILE_NAME);
//    if (inputStream == null) {
//      logger.debug("no rsa private key file named {} found in classpath", FILE_NAME);
//    } else {
//      rsaPrivateKey = RSAUtil.readPrivateKey(inputStream);
//    }
  }

  @Override
  public void callback(Config config) {
    for (String key : config.getData().keySet()) {
      String value = (String) config.getData().get(key);
      if (value != null && value.startsWith(PREFIX)) {
        value = decode(value.substring(PREFIX.length()));
        if (value != null) {
          config.getData().put(key, value);
        }

      }
    }
  }

  protected String decode(String encodedData) {
//    if (rsaPrivateKey != null) {
//      return RSAUtil.decrypt(encodedData, rsaPrivateKey);
//    } else {
//      return null;
//    }
    return encodedData;
  }

}
