package com.flywolf.li.framework.configcenter.utils;

import java.io.File;
import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

public class RSAUtil {
  private static final String RSA = "RSA";
  private static final int KEYSIZE = 1024;
  private static final String PUBLIC_KEY_FILE = "rsa.public";
  private static final String PRIVATE_KEY_FILE = "rsa.private";

  public static RSAKeyPair generateKeyPair() {
    return generateKeyPair(null);
  }

  public static RSAKeyPair generateKeyPair(File dir) {
    KeyPairGenerator kpg;
    try {
      kpg = KeyPairGenerator.getInstance(RSA);
      kpg.initialize(KEYSIZE, new SecureRandom());
      KeyPair kp = kpg.generateKeyPair();

      RSAKeyPair rsaKeyPair = new RSAKeyPair(kp);
      if (dir != null) {
        dir.mkdirs();
        save(rsaKeyPair.getPrivateKey(), new File(dir, PUBLIC_KEY_FILE));
        save(rsaKeyPair.getPublicKey(), new File(dir, PRIVATE_KEY_FILE));
      }

      return rsaKeyPair;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void save(RSAPublicKey publicKey, File file) {
    FileUtils.saveObject(file, publicKey);
  }

  public static void save(RSAPrivateKey privateKey, File file) {
    FileUtils.saveObject(file, privateKey);
  }

  public static RSAPublicKey readPublicKey(File file) {
    return ((RSAPublicKey) FileUtils.readObject(file, RSAPublicKey.class));
  }

  public static RSAPrivateKey readPrivateKey(File file) {
    return ((RSAPrivateKey) FileUtils.readObject(file, RSAPrivateKey.class));
  }

  public static RSAPublicKey readPublicKey(InputStream is) {
    return ((RSAPublicKey) FileUtils.readObject(is, RSAPublicKey.class));
  }

  public static RSAPrivateKey readPrivateKey(InputStream is) {
    return ((RSAPrivateKey) FileUtils.readObject(is, RSAPrivateKey.class));
  }

  public static String encrypt(String data, RSAPublicKey publicKey) {
    Cipher cipher;
    try {
      cipher = Cipher.getInstance(RSA);
      cipher.init(1, publicKey);

      int key_len = publicKey.getModulus().bitLength() / 8;

      String[] datas = splitString(data, key_len - 11);
      String mi = "";

      String[] arrayOfString1 = datas;
      int i = arrayOfString1.length;
      for (int j = 0; j < i; ++j) {
        String s = arrayOfString1[j];
        mi = mi + bcd_to_str(cipher.doFinal(s.getBytes()));
      }
      return mi;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static String decrypt(String data, RSAPrivateKey privateKey) {
    Cipher cipher;
    try {
      cipher = Cipher.getInstance(RSA);
      cipher.init(2, privateKey);

      int key_len = privateKey.getModulus().bitLength() / 8;
      byte[] bytes = data.getBytes();
      byte[] bcd = asc_to_bcd(bytes, bytes.length);

      String ming = "";
      byte[][] arrays = splitArray(bcd, key_len);
      byte[][] arrayOfByte1 = arrays;
      int i = arrayOfByte1.length;
      for (int j = 0; j < i; ++j) {
        byte[] arr = arrayOfByte1[j];
        ming = ming + new String(cipher.doFinal(arr));
      }
      return ming;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  protected static byte[] asc_to_bcd(byte[] ascii, int asc_len) {
    byte[] bcd = new byte[asc_len / 2];
    int j = 0;
    for (int i = 0; i < (asc_len + 1) / 2; ++i) {
      bcd[i] = asc_to_bcd(ascii[(j++)]);
      bcd[i] = (byte) (((j >= asc_len) ? 0 : asc_to_bcd(ascii[(j++)])) + (bcd[i] << 4));
    }
    return bcd;
  }

  protected static byte asc_to_bcd(byte asc) {
    byte bcd;
    if ((asc >= 48) && (asc <= 57))
      bcd = (byte) (asc - 48);
    else if ((asc >= 65) && (asc <= 70))
      bcd = (byte) (asc - 65 + 10);
    else if ((asc >= 97) && (asc <= 102))
      bcd = (byte) (asc - 97 + 10);
    else
      bcd = (byte) (asc - 48);
    return bcd;
  }

  protected static String bcd_to_str(byte[] bytes) {
    char[] temp = new char[bytes.length * 2];

    for (int i = 0; i < bytes.length; ++i) {
      char val = (char) ((bytes[i] & 0xF0) >> 4 & 0xF);
      temp[(i * 2)] = (char) ((val > '\t') ? val + 'A' - 10 : val + '0');

      val = (char) (bytes[i] & 0xF);
      temp[(i * 2 + 1)] = (char) ((val > '\t') ? val + 'A' - 10 : val + '0');
    }
    return new String(temp);
  }

  protected static String[] splitString(String string, int len) {
    int x = string.length() / len;
    int y = string.length() % len;
    int z = 0;
    if (y != 0)
      z = 1;

    String[] strings = new String[x + z];
    String str = "";
    for (int i = 0; i < x + z; ++i) {
      if ((i == x + z - 1) && (y != 0))
        str = string.substring(i * len, i * len + y);
      else
        str = string.substring(i * len, i * len + len);

      strings[i] = str;
    }
    return strings;
  }

  protected static byte[][] splitArray(byte[] data, int len) {
    int x = data.length / len;
    int y = data.length % len;
    int z = 0;
    if (y != 0)
      z = 1;

    byte[][] arrays = new byte[x + z][];

    for (int i = 0; i < x + z; ++i) {
      byte[] arr = new byte[len];
      if ((i == x + z - 1) && (y != 0))
        System.arraycopy(data, i * len, arr, 0, y);
      else
        System.arraycopy(data, i * len, arr, 0, len);

      arrays[i] = arr;
    }
    return arrays;
  }
}
