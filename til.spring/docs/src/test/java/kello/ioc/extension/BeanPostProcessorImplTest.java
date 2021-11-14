package kello.ioc.extension;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BeanPostProcessorImplTest {

  @Test
  public void test() {
    var context = new ClassPathXmlApplicationContext("extension.xml");
    var bean = context.getBean("testBean", TestBean.class);
    bean.print();
  }
}
