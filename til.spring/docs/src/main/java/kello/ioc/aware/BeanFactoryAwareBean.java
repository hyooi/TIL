package kello.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryAwareBean implements BeanFactoryAware {

  private BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
    System.out.println("[BeanFactoryAwareBean] setBeanFactory");
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }
}
