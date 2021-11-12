package kello.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareBean implements ApplicationContextAware {
  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    System.out.println("[ApplicationContextAwareBean] setApplicationContext");
  }

  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }

}
