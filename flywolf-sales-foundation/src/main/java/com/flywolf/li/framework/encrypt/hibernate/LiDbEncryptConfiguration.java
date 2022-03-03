package com.flywolf.li.framework.encrypt.hibernate;

import com.flywolf.li.framework.encrypt.utils.CryptUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration("liDbEncryptConfiguration")
public class LiDbEncryptConfiguration {

  @Bean
  public CryptUtils cryptUtils() {
    return new CryptUtils();
  }

}
