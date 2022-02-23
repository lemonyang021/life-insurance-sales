package com.flywolf.li.pub;

import java.util.UUID;

public interface IdUtils {

  UUID uuid();

  String id16();

  String idWithPrefix(String prefix);
}
