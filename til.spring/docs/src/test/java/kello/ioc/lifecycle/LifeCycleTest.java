package kello.ioc.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class LifeCycleTest {

  @Test
  void lifeCycle() {
    var context = new ClassPathXmlApplicationContext("lifecycle.xml");;
    var bean = context.getBean("lifeCycle", LifeCycle.class);

    context.close();
  }

  @Test
  void lifeCycleWithDefaultMethod() {
    var context = new ClassPathXmlApplicationContext("lifecycle.xml");;
    var bean = context.getBean("lifeCycleWithDefaultMethod", LifeCycle.class);

    context.close();
  }
}
