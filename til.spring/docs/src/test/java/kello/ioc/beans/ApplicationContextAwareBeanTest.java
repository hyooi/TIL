package kello.ioc.beans;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ApplicationContextAwareBeanTest {
  @Test
  void test() {
    var context = new ClassPathXmlApplicationContext("services.xml");
    var bean = context.getBean("applicationContextAwareBean", ApplicationContextAwareBean.class);

    assertThat(bean.count()).isEqualTo(1000);
  }
}
