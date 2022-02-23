package com.flywolf.li.sales.online.server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class LocalDateTimeSerializerConfig {

    @Value("${spring.jackson.date-format:yyyy-MM-dd'T'HH:mm:ss.SSS'Z'}")
    private String pattern;

    /**
     *  注册响应json格式的LocalDateTime日期格式序列化器,指定格式
     *
     * @return LocalDateTimeSerializer
     */
    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    /** 
     *  注册json请求方式的LocalDateTime反序列化器,指定格式
     *
     * @return LocalDateTimeDeserializer 
     */
    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     *  格式化日期类型,响应对应格式化日期字符串
     *
     * @return Jackson2ObjectMapperBuilderCustomizer
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            //返回json格式,前端序列化为字符串
            builder.serializerByType(LocalDateTime.class, localDateTimeSerializer());
            //从json对象日期字符串反序列化为日期对象
            builder.deserializerByType(LocalDateTime.class, localDateTimeDeserializer());
        };
    }
}
