package com.flywolf.li.pub;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CompositeDateFormat extends SimpleDateFormat {

  private static final long serialVersionUID = 9097368994424959413L;

  private static final String DATE_PATTERN = "yyyy-MM-dd";

  private static final String DEFAULT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

  private static final String MS_SUFFIX = ".SSS";

  private static final String TIMEZONE_SUFFIX = ".SSSXX";

  private SimpleDateFormat dateFormat;

  private SimpleDateFormat specifiedFormat;

  private SimpleDateFormat msFormat;

  private SimpleDateFormat timezoneFormat;

  public CompositeDateFormat() {
    this(DEFAULT_PATTERN);
  }

  public CompositeDateFormat(String pattern) {
    super(DEFAULT_PATTERN);
    dateFormat = new SimpleDateFormat(DATE_PATTERN);
    specifiedFormat = new SimpleDateFormat(pattern);
    msFormat = new SimpleDateFormat(pattern.endsWith(MS_SUFFIX) ? pattern : pattern + MS_SUFFIX);
    timezoneFormat = new SimpleDateFormat(
        pattern.endsWith(TIMEZONE_SUFFIX) ? pattern : pattern + TIMEZONE_SUFFIX);
  }

  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    return specifiedFormat.format(date, toAppendTo, fieldPosition);
  }

  @Override
  public Date parse(String source, ParsePosition pos) {
    int orgIndex = pos.getIndex();
    Date date = dateFormat.parse(source, pos);
    if (date != null && pos.getIndex() == source.length()) {
      return date;
    }
    pos.setIndex(orgIndex);
    date = super.parse(source, pos);
    if (date != null && pos.getIndex() == source.length()) {
      return date;
    }
    pos.setIndex(orgIndex);
    date = specifiedFormat.parse(source, pos);
    if (date != null && pos.getIndex() == source.length()) {
      return date;
    }
    pos.setIndex(orgIndex);
    date = msFormat.parse(source, pos);
    if (date != null && pos.getIndex() == source.length()) {
      return date;
    }
    pos.setIndex(orgIndex);
    date = timezoneFormat.parse(source, pos);
    if (date != null && pos.getIndex() == source.length()) {
      return date;
    }
    throw new IllegalArgumentException(source + " not match " + super.toPattern());
  }

  @Override
  public Date parse(String source) throws ParseException {
    return super.parse(source);
  }

  @Override
  public void setTimeZone(TimeZone zone) {
    super.setTimeZone(zone);
    dateFormat.setTimeZone(zone);
    specifiedFormat.setTimeZone(zone);
    msFormat.setTimeZone(zone);
    timezoneFormat.setTimeZone(zone);
  }

  @Override
  public CompositeDateFormat clone() {
    CompositeDateFormat other = (CompositeDateFormat) super.clone();
    other.dateFormat = (SimpleDateFormat) this.dateFormat.clone();
    other.specifiedFormat = (SimpleDateFormat) this.specifiedFormat.clone();
    other.msFormat = (SimpleDateFormat) this.msFormat.clone();
    other.timezoneFormat = (SimpleDateFormat) this.timezoneFormat.clone();
    return other;
  }

}