package com.flywolf.li.pub;

import java.lang.management.ManagementFactory;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class IdUtilsImpl implements IdUtils {

  @Override
  public UUID uuid() {
    return UUID.nameUUIDFromBytes(id16().getBytes());
  }

  private final String pid = format(getPid());

  protected short getLoTime() {
    short loTime = (short) (System.nanoTime() >>> 16);
    return loTime > 0 ? (short) (Short.MAX_VALUE - loTime) : (short) (Short.MAX_VALUE + loTime);
  }

  protected String format(int intval) {
    String formatted = Integer.toHexString(intval);
    StringBuilder buf = new StringBuilder("00000000");
    if (formatted.length() > 8) {
      formatted = formatted.substring(0, 4);
    }
    buf.replace(8 - formatted.length(), 8, formatted);
    return buf.toString();
  }

  protected String format(short shortval) {
    String formatted = Integer.toHexString(shortval);
    if (formatted.length() > 4) {
      formatted = formatted.substring(0, 4);
    }
    StringBuilder buf = new StringBuilder("0000");
    buf.replace(4 - formatted.length(), 4, formatted);
    return buf.toString();
  }

  private AtomicInteger counter = new AtomicInteger(0);

  protected int getCount() {
    int c = counter.incrementAndGet();
    if (c < 0) {
      c = 0;
      counter.compareAndSet(c, 0);
    }
    return c;
  }

  protected short getPid() {
    String name = ManagementFactory.getRuntimeMXBean().getName();
    String processid = name.split("@")[0];
    return Short.parseShort(processid.substring(0, Math.min(4, processid.length())));
  }

  public String id16() {
    return new StringBuilder(16).append(pid).append(format(getLoTime())).append(format(getCount()))
        .toString();
  }

  public String idWithPrefix(String prefix) {
    return prefix + id16();
  }

}
