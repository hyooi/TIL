package kello.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import kello.ioc.beans.FirstDao;
import kello.ioc.beans.FirstService;
import kello.ioc.beans.SecondDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

  @Test
  @DisplayName("Xml을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_xml() {
    var context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
    assertThat(context.getBeanDefinitionNames())
        .contains("firstDao", "secondDao", "firstService");

    var service = context.getBean("firstService", FirstService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("어노테이션을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_annotation() {
    var context = new AnnotationConfigApplicationContext(FirstDao.class, SecondDao.class, FirstService.class);
    assertThat(context.getBeanDefinitionNames())
        .contains("firstDao", "secondDao", "firstService");

    var service = context.getBean("firstService", FirstService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }
}
