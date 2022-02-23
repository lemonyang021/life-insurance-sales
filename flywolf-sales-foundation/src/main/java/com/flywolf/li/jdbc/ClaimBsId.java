package com.flywolf.li.jdbc;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component(ClaimBsId.BEAN_DEFAULT)
public class ClaimBsId {
  
  static final String BEAN_DEFAULT = "claimBsId";
  String claimBsSequence = "CLAIMBS_JPA_SEQUENCE";
  
  @Resource(name = ClaimBsSequence.BEAN_DEFAULT)
  ClaimBsSequence sequence;

  public long id() {
    return sequence.nextVal(claimBsSequence);
  }
}
