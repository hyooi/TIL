package kello.ioc.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
BeanPostProcessor :
- 초기화 로직 정의
- 의존성 정의로직 정의
- BeanPostProcessor로 등록된 인스턴스는 order순서에 상관없이 자동 처리됨
ex. AutowiredAnnotationBeanPostProcessor
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("[BeanPostProcessorBean] postProcessBeforeInitialization");
    System.out.println("bean : "+ bean + ", beanName: " + beanName);

    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("[BeanPostProcessorBean] postProcessAfterInitialization");
    System.out.println("bean : "+ bean + ", beanName: " + beanName);

    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }

  public void test() {
    System.out.println("test");
  }
}
