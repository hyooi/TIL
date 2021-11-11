package kello.ioc.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class LifeCycleTest {

  @Test
  void test() {
    var context = new ClassPathXmlApplicationContext("lifecycle.xml");;
    var bean = context.getBean("lifeCycle", LifeCycle.class);

    context.close();
  }
}
