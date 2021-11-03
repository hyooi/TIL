package kello.ioc.beans.dependency;

import java.util.Properties;

public class PropertyBean {
  private final Properties properties;

  public PropertyBean(Properties properties) {
    this.properties = properties;
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
