package com.flywolf.li.pub;

import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//@Service
public class ObjectMapperUtils {

  //@Autowired(required = false)
  private DateFormatProxy dateFormatProxy;

  //@Bean
  public ObjectMapper getObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    objectMapper
        .setDateFormat(dateFormatProxy != null ? dateFormatProxy: new CompositeDateFormat());
    objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    return objectMapper;
  }


}
