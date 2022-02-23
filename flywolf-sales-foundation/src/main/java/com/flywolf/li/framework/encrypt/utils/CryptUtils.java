package com.flywolf.li.framework.encrypt.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.flywolf.li.framework.encrypt.hibernate.DBEncryptRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;


public class CryptUtils {

  private static final ThreadLocal<ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>>> encryptCipherThreadLocal =
      new ThreadLocal<>();
  private static final ThreadLocal<ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>>> decryptCipherThreadLocal =
      new ThreadLocal<>();

  @Autowired
  private ApplicationContext applicationContext;

  private static Environment environment = null;

  @PostConstruct
  public void init() {
    CryptUtils.environment = applicationContext.getEnvironment();
  }

  private static final Logger logger = LoggerFactory.getLogger(CryptUtils.class);
  private static final String KEY_AES = "AES/CBC/PKCS5Padding";
  public static final String ENCRYPT_PREFIX = "{{##AES##}}";
  public static final String ENCRYPT_KEY = "claimbs.db.encrypt.key";
  public static final String ENCRYPT_IV = "claimbs.db.encrypt.iv";
  public static final String ENCRYPT_ENABLED = "claimbs.db.encrypt.enabled";

  public static boolean isEncrypted(String value) {
    return (StringUtils.isNotBlank(value) && value.startsWith(ENCRYPT_PREFIX));
  }

  public static boolean isDbEncryptEnabled() {
    return "true".equalsIgnoreCase(environment.getProperty(ENCRYPT_ENABLED, "false"));
  }

  public static String encrypt(String value, boolean checkAsciiPrintable) {
    return encryptAsBase64(value, environment.getProperty(ENCRYPT_KEY),
        environment.getProperty(ENCRYPT_IV), checkAsciiPrintable);
  }

  public static String encrypt(String value) {
    return encryptAsBase64(value, environment.getProperty(ENCRYPT_KEY),
        environment.getProperty(ENCRYPT_IV), false);
  }

  public static String encrypt(String value, String key, String iv) {
    return encryptAsBase64(value, key, iv, false);
  }

  public static String decrypt(String value, boolean checkAsciiPrintable) {
    return decryptFromBase64(value, environment.getProperty(ENCRYPT_KEY),
        environment.getProperty(ENCRYPT_IV), checkAsciiPrintable);
  }

  public static String decrypt(String value) {
    return decryptFromBase64(value, environment.getProperty(ENCRYPT_KEY),
        environment.getProperty(ENCRYPT_IV), false);
  }

  public static String decrypt(String value, String key, String iv) {
    return decryptFromBase64(value, key, iv, false);
  }

  private static String encryptAsBase64(String srcData, String key, String iv,
      boolean checkAsciiPrintable) {
    byte[] bytes;
    if (StringUtils.isEmpty(srcData)) {
      return srcData;
    }
    keyIVCheck(key, iv);
    if (srcData.startsWith(ENCRYPT_PREFIX)) {
      return srcData;
    }
    if ((checkAsciiPrintable) && (!StringUtils.isAsciiPrintable(srcData))) {
      logger.error("Data to be encrypted is not ascii printable,current:{}", srcData);
      throw new DBEncryptRuntimeException(
          "Data to be encrypted is not ascii printable,current:" + srcData);
    }
    bytes = srcData.getBytes(StandardCharsets.UTF_8);
    byte[] encryptData = encrypt(bytes, key, iv);
    return ENCRYPT_PREFIX.concat(Base64.getEncoder().encodeToString(encryptData));
  }

  private static byte[] encrypt(byte[] bytes, String key, String iv) {
    Cipher cipher = getEncryptCipher(key, iv);
    try {
      return cipher.doFinal(bytes);
    } catch (IllegalBlockSizeException | BadPaddingException | RuntimeException e) {
      encryptCipherThreadLocal.get().get(key).remove(iv);
      throw new DBEncryptRuntimeException(e);
    }
  }

  private static byte[] decrypt(byte[] bytes, String key, String iv) {
    Cipher cipher = getDecryptCipher(key, iv);
    try {
      return cipher.doFinal(bytes);
    } catch (Exception e) {
      decryptCipherThreadLocal.get().get(key).remove(iv);
      throw new DBEncryptRuntimeException(e);
    }
  }

  private static String decryptFromBase64(String encryptedData, String key, String iv,
      boolean checkAsciiPrintable) {
    if (StringUtils.isEmpty(encryptedData)) {
      return encryptedData;
    }
    if (!encryptedData.startsWith(ENCRYPT_PREFIX)) {
      logger.warn("Decrypted data must be start with {},current:{}", ENCRYPT_PREFIX, encryptedData);
      return encryptedData;
    }
    keyIVCheck(key, iv);
    String result;
    encryptedData = encryptedData.substring(ENCRYPT_PREFIX.length());
    byte[] bytes = Base64.getDecoder().decode(encryptedData);
    byte[] original = decrypt(bytes, key, iv);
    result = new String(original, StandardCharsets.UTF_8);
    if ((checkAsciiPrintable) && (!StringUtils.isAsciiPrintable(result))) {
      throw new DBEncryptRuntimeException(
          "Decrypted data is not ascii printable, maybe using invalid key/iv/mode when decrypt data. Current:"
              + encryptedData);
    }
    return result;
  }

  private static void keyIVCheck(String key, String iv) {
    // key校验
    if (key == null) {
      throw new DBEncryptRuntimeException("key can't be null!");
    } else if (key.length() != 32) {
      throw new DBEncryptRuntimeException("key must be 32 bytes!");
    }

    // iv校验
    if (iv == null) {
      throw new DBEncryptRuntimeException("iv can't be null!");
    } else if (iv.length() != 16) {
      throw new DBEncryptRuntimeException("iv must be 16 bytes!");
    }
  }

  private static Cipher createEncryptCipher(String key, String iv) {
    try {
      Cipher cipher = Cipher.getInstance(KEY_AES);
      SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
      cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
      return cipher;
    } catch (Exception e) {
      throw new DBEncryptRuntimeException(e);
    }
  }

  private static Cipher createDecryptCipher(String key, String iv) {
    try {
      Cipher cipher = Cipher.getInstance(KEY_AES);
      SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
      cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
      return cipher;
    } catch (Exception e) {
      throw new DBEncryptRuntimeException(e);
    }
  }

  private static Cipher getEncryptCipher(String key, String iv) {
    try {
      Cipher cipher;
      ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>> cipherMap =
          encryptCipherThreadLocal.get();
      if (cipherMap == null || cipherMap.get(key) == null || cipherMap.get(key).get(iv) == null) {
        cipher = createEncryptCipher(key, iv);
        ConcurrentHashMap<String, Cipher> ivMap = new ConcurrentHashMap<>();
        ivMap.put(iv, cipher);
        ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>> keyMap =
            new ConcurrentHashMap<>();
        keyMap.put(key, ivMap);
        encryptCipherThreadLocal.set(keyMap);
      } else {
        cipher = cipherMap.get(key).get(iv);
      }
      return cipher;
    } catch (Exception e) {
      encryptCipherThreadLocal.remove();
      throw new DBEncryptRuntimeException(e);
    }
  }

  private static Cipher getDecryptCipher(String key, String iv) {
    try {
      Cipher cipher;
      ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>> cipherMap =
          decryptCipherThreadLocal.get();
      if (cipherMap == null || cipherMap.get(key) == null || cipherMap.get(key).get(iv) == null) {
        cipher = createDecryptCipher(key, iv);
        ConcurrentHashMap<String, Cipher> ivMap = new ConcurrentHashMap<>();
        ivMap.put(iv, cipher);
        ConcurrentHashMap<String, ConcurrentHashMap<String, Cipher>> keyMap =
            new ConcurrentHashMap<>();
        keyMap.put(key, ivMap);
        decryptCipherThreadLocal.set(keyMap);
      } else {
        cipher = cipherMap.get(key).get(iv);
      }
      return cipher;
    } catch (Exception e) {
      decryptCipherThreadLocal.remove();
      throw new DBEncryptRuntimeException(e);
    }
  }

  public static void unloadEncryptCipher() {
    encryptCipherThreadLocal.remove();
  }

  public static void unloadDecryptCipher() {
    decryptCipherThreadLocal.remove();
  }
}
