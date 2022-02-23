package com.flywolf.li.framework.configcenter.listeners;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReCofigableMetadataHolder {
  private static final ReCofigableMetadataHolder INSTANCE = new ReCofigableMetadataHolder();

  private ConcurrentMap<String, ReConfigableMetadata> metadatas = new ConcurrentHashMap<>();

  private ReCofigableMetadataHolder() {

  }

  public static ReCofigableMetadataHolder getInstace() {
    return INSTANCE;
  }

  public ReCofigableMetadataHolder register(ReConfigableMetadata metadata) {
    if (metadatas.containsKey(metadata.getConfigPattern())
        && !metadatas.get(metadata.getConfigPattern()).getSource().equals(metadata.getSource())) {
      String existeClassName =
          metadatas.get(metadata.getConfigPattern()).getSource().getClass().getName();
      String currentClassName = metadata.getSource().getClass().getName();

      throw new RuntimeException("ConfigurationProperties Annotation prefix attribute value ["
          + metadata.getConfigPattern() + "] already existed at " + existeClassName + " and "
          + currentClassName);
    }
    metadatas.put(metadata.getConfigPattern(), metadata);
    return this;
  }

  public ReConfigableMetadata fetch(String key) {
    if (metadatas.containsKey(key)) {
      return metadatas.get(key);
    } else {
      for (String pattern : metadatas.keySet()) {
        if (key.startsWith(pattern)) {
          return metadatas.get(pattern);
        }
      }
    }

    return null;
  }
}
