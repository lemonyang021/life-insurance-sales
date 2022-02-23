package com.flywolf.li.jdbc;

import com.flywolf.li.framework.context.DBContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ClaimBsSequence {

  String BEAN_DEFAULT = "distibuteSequence";
  
  @Transactional(value = DBContext.TRANS_TM, propagation = Propagation.REQUIRES_NEW)
  public long getNextValueFromDB(String sequenceName);
  
  @Transactional(value = DBContext.TRANS_TM)
  public ClaimBsSequenceInfo getSequenceInfo(String sequenceName);
  
  public long nextVal(String sequenceName);
}
