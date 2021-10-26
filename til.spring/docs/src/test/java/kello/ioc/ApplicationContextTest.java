package kello.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import kello.ioc.beans.ADao;
import kello.ioc.beans.AService;
import kello.ioc.beans.BDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

  @Test
  @DisplayName("Xml을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_xml() {
    var context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
    var beans = context.getBeanDefinitionNames();
    assertThat(beans)
        .hasSize(3)
        .containsExactly("aDao", "bDao", "aService");

    var service = context.getBean("aService", AService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("어노테이션을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_annotation() {
    var context = new AnnotationConfigApplicationContext(ADao.class, BDao.class, AService.class);
    var beans = context.getBeanDefinitionNames();
    assertThat(beans)
        .hasSize(8)
        .contains("ADao", "BDao", "AService");

    var service = context.getBean("AService", AService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }
}
