package kello.ioc.aware;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BeanNameAwareBeanTest {

  @Test
  void test() {
    var context = new ClassPathXmlApplicationContext("aware.xml");
    var bean = context.getBean("beanNameAwareBean", BeanNameAwareBean.class);

    assertThat(bean.getName()).isEqualTo("beanNameAwareBean");
  }
}
