package com.flywolf.li.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import com.flywolf.li.framework.context.DBContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component(ClaimBsSequence.BEAN_DEFAULT)
public class ClaimBsSequenceImpl implements ClaimBsSequence {

  private static Logger logger = LoggerFactory.getLogger(ClaimBsSequenceImpl.class);

  private static final String SQL_UPDATE =
      "update T_CLAIMBS_SEQUENCE set NEXT_NUMBER=NEXT_NUMBER+CACHE_SIZE*INCREMENT_BY,MODIFY_TIME=now() where SEQUENCE_NAME=?";

  // ensure uniqueness by db trans lock
  private static final String SQL_SELECT =
      "select NEXT_NUMBER from T_CLAIMBS_SEQUENCE where SEQUENCE_NAME=?";

  @Resource(name = DBContext.TRANS_JT)
  private JdbcTemplate jdbcTemplate;

  @Override
  public long getNextValueFromDB(String sequenceName) {

    StopWatch sw = new StopWatch("claimbsSequence.getNextValueFromDB()");
    sw.start();
    jdbcTemplate.update(SQL_UPDATE, sequenceName);
    sw.stop();
    if (sw.getTotalTimeMillis() > 10) {
      logger.warn("get next value of sequence {} in {}ms", sequenceName, sw.getTotalTimeMillis());
    }

    long nextVal = jdbcTemplate.queryForObject(SQL_SELECT, new Object[] {sequenceName}, Long.class);

    // check cachesize
    check(sequenceName,nextVal);

    return nextVal;
  }

  @Override
  public ClaimBsSequenceInfo getSequenceInfo(String sequenceName) {

    try {
      ClaimBsSequenceInfo sequenceInfo = this.jdbcTemplate.queryForObject(
          "select * from T_CLAIMBS_SEQUENCE where SEQUENCE_NAME=?", new Object[] {sequenceName},
          new RowMapper<ClaimBsSequenceInfo>() {
            @Override
            public ClaimBsSequenceInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
              ClaimBsSequenceInfo info = new ClaimBsSequenceInfo();
              info.setCacheSize(rs.getInt("CACHE_SIZE"));
              info.setIncrementBy(rs.getInt("INCREMENT_BY"));
              info.setNextNumber(rs.getLong("NEXT_NUMBER"));
              info.setSequenceName(sequenceName);
              return info;
            }
          });
      return sequenceInfo;
    } catch (EmptyResultDataAccessException e) {
      throw new IllegalArgumentException(sequenceName + " not found in T_CLAIMBS_SEQUENCE", e);
    }
  }


  private void check(String sequenceName, long nextVal) {
    // initial or maybe cachesize changed
    if (incrementBy == -1 || cacheSize == -1 || !(nextVal == hiValue - incrementBy * cacheSize)) {
      ClaimBsSequenceInfo seqInfo = this.getSequenceInfo(sequenceName);
      this.incrementBy = seqInfo.getIncrementBy();
      this.cacheSize = seqInfo.getCacheSize();
    }
  }

  @Override
  public synchronized long nextVal(String sequenceName) {

    if (!(hiValue > nextValue) || hiValue == 0) {
      hiValue = this.getNextValueFromDB(sequenceName);
      nextValue = hiValue - incrementBy * cacheSize;
    }
    nextValue += incrementBy;
    return nextValue;
  }

  private long hiValue = 0;
  private long nextValue = 0;// java next value(from java cache)
  private int incrementBy = -1;
  private int cacheSize = -1;
}
