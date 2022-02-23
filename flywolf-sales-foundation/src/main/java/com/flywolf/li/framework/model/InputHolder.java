package com.flywolf.li.framework.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputHolder<T> {
  private Map<Serializable, T> map = new HashMap<Serializable, T>();
  private String holderName;
  private String idName;

  @Deprecated
  public InputHolder() {
    idName = "id";
  }

  public InputHolder(String holderName, String idName) {
    this.holderName = holderName;
    this.idName = idName;
  }

  public void put(Serializable id, T t) {
    if (id == null || t == null) {
      throw new NullPointerException(id + ":" + t);
    }
    if (holderName == null) {
      holderName = t.getClass().getSimpleName();
    }
    map.put(id, t);
  }

  public boolean containsKey(Serializable id) {
    return map.containsKey(id);
  }

  public T get(Serializable id) {
    if (id == null) {
      throw new IllegalArgumentException("fail to get " + holderName + " with null " + idName);
    }
    T value = map.get(id);
    if (value == null) {
      throw new IllegalArgumentException(
          "fail to get " + holderName + " with " + idName + id.toString());
    }
    return value;
  }

  public Set<Serializable> keys() {
    return map.keySet();
  }

  public Collection<T> values() {
    return map.values();
  }

  public void clear() {
    map.clear();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }
}
