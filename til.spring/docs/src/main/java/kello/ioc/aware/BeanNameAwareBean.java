package kello.ioc.aware;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareBean implements BeanNameAware {

  private String name;

  @Override
  public void setBeanName(String name) {
    this.name = name;
    System.out.println("[BeanNameAwareBean] setBeanName");
  }

  public String getName() {
    return name;
  }
}
