package com.flywolf.li.pub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DateFormatProxy extends SimpleDateFormat{

  private static final long serialVersionUID = 2033946446009403476L;

  @Value("${spring.jackson.time-zone}")
  private TimeZone timeZone;
  protected static TimeZone DEFAULT_TIMEZONE;
  protected static final String DefaultDateFormat ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";// "yyyy-MM-dd'T'HH:mm:ss";


  public DateFormatProxy() {}

  @PostConstruct
  public void init() {
    DEFAULT_TIMEZONE = timeZone;// NOSONAR
  }

  public DateFormat getDateFormat() {

    SimpleDateFormat simpleDateFormat = new CompositeDateFormat(DefaultDateFormat);
    simpleDateFormat.setTimeZone(DEFAULT_TIMEZONE);
    return simpleDateFormat;

  }

}
