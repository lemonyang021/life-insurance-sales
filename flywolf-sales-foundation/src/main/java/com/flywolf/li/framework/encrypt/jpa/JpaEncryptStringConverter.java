package com.flywolf.li.framework.encrypt.jpa;

import javax.persistence.AttributeConverter;

import com.flywolf.li.framework.encrypt.utils.CryptUtils;
import org.apache.commons.lang.StringUtils;


public class JpaEncryptStringConverter implements AttributeConverter<String, String> {

  @Override
  public String convertToDatabaseColumn(String attribute) {
    if (StringUtils.isNotBlank(attribute) && CryptUtils.isDbEncryptEnabled()) {
      return CryptUtils.encrypt(attribute, false);
    }
    return attribute;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    if (CryptUtils.isDbEncryptEnabled() && CryptUtils.isEncrypted(dbData)) {
      return CryptUtils.decrypt(dbData, false);
    }
    return dbData;
  }

}
