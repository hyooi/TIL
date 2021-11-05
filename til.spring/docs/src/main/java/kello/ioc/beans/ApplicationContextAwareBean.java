package kello.ioc.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareBean implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  public int count() {
    return this.applicationContext.getBean("constructorService", ConstructorService.class)
        .getCount();
  }

  //ApplicationContextAwareBean이 생성됨과 동시에 해당 메소드를 호출함
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
