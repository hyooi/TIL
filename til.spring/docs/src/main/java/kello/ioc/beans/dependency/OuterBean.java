package kello.ioc.beans.dependency;

public class OuterBean {
  private PropertyBean propertyBean;

  public void setPropertyBean(PropertyBean propertyBean) {
    this.propertyBean = propertyBean;
  }

  public String getKey() {
    return propertyBean.getProperty("key01");
  }
}
