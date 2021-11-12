package kello.ioc.aware;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BeanFactoryAwareBeanTest {

  @Test
  void test() {
    var context = new ClassPathXmlApplicationContext("aware.xml");
    var bean = context.getBean("beanFactoryAwareBean", BeanFactoryAwareBean.class);

    var factory = bean.getBeanFactory();
    assertThat(factory)
        .isNotNull()
        .isExactlyInstanceOf(DefaultListableBeanFactory.class);

    assertThat(factory.containsBean("beanFactoryAwareBean")).isTrue();
  }
}
