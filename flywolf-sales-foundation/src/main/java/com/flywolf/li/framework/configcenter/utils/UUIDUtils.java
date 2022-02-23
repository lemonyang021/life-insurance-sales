package com.flywolf.li.framework.configcenter.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDUtils {
  private UUIDUtils() {}

  private static final char[] HEX_CHARS =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  public static String uuid16() {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-1");
      byte[] bytes = digest.digest(uuid32().getBytes(StandardCharsets.UTF_8));
      return new String(encodeHex(bytes, 0, 8));
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  public static String uuid32() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  private static char[] encodeHex(byte[] bytes, int offset, int length) {
    char chars[] = new char[length];
    for (int i = 0; i < length; i = i + 2) {
      byte b = bytes[offset + (i / 2)];
      chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
      chars[i + 1] = HEX_CHARS[b & 0xf];
    }
    return chars;
  }
}
