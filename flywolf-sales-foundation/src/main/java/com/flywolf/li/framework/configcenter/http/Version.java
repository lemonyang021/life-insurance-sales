package com.flywolf.li.framework.configcenter.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class Version {

  private Logger logger = LoggerFactory.getLogger(Version.class);
  private String version = null;
  private String buildAt = null;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getBuildAt() {
    return buildAt;
  }

  public void setBuildAt(String buildAt) {
    this.buildAt = buildAt;
  }

  public Version() {
    this(false);
  }

  public Version(boolean local) {
    if (local) {
      readVersion();
    }
  }

  /**
   */
  private void readVersion() {
    File versionFile = new File(".", "target/version.properties");
    boolean successful = false;
    try {
      if (versionFile.exists()) {
        successful = readVersion(new FileInputStream(versionFile));
      } else {
        String res = "/version.properties";
        successful = readVersion(this.getClass().getResourceAsStream(res));
      }
      if (successful == false) {
        throw new RuntimeException("can not found version.properties");
      }
    } catch (Exception ex) {
      String defaultBuildAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      String defaultVer = "dev-local-ver";
      setBuildAt(defaultBuildAt);
      setVersion(defaultVer);
      logger.warn("version file can not be read,use default {}/{}", defaultVer, defaultBuildAt);
    }
  }

  protected boolean readVersion(InputStream is) {
    String keyOfVersion = "version";
    String keyOfBuildAt = "buildAt";
    try {
      Properties properties = new Properties();
      properties.load(is);
      setVersion(properties.getProperty(keyOfVersion));
      setBuildAt(properties.getProperty(keyOfBuildAt));
      Assert.notNull(getVersion(), keyOfVersion);
      Assert.notNull(getBuildAt(), keyOfBuildAt);
      return true;
    } catch (Exception ex) {
      setVersion(null);
      setBuildAt(null);
      return false;
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
        }
      }
    }

  }
}
