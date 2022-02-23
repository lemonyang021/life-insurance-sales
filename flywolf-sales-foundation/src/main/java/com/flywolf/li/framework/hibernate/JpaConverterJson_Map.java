package com.flywolf.li.framework.hibernate;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.persistence.AttributeConverter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class JpaConverterJson_Map implements AttributeConverter<HashMap<String, String>, String> {

  private static ObjectMapper objectMapper = new ObjectMapper();
  
  @PostConstruct
  public void init() {
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    objectMapper.setSerializationInclusion(Include.NON_NULL);
  }

  @Override
  public String convertToDatabaseColumn(HashMap<String, String> meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (JsonProcessingException ex) {
      throw new RuntimeException(ex);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public HashMap<String, String> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, HashMap.class);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

}
