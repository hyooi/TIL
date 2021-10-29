package kello.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import kello.ioc.beans.FactoryMethodDao;
import kello.ioc.beans.ConstructorService;
import kello.ioc.beans.InstanceFactoryMethodDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

  @Test
  @DisplayName("Xml을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_xml() {
    var context = new ClassPathXmlApplicationContext("services.xml");
    assertThat(context.getBeanDefinitionNames())
        .contains("factoryMethodDao", "instanceFactoryMethodDao", "constructorService");

    var service = context.getBean("constructorService", ConstructorService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("어노테이션을 통한 어플리케이션 컨텍스트 생성 테스트")
  void applicationContext_annotation() {
    var context = new AnnotationConfigApplicationContext(FactoryMethodDao.class, InstanceFactoryMethodDao.class, ConstructorService.class);
    assertThat(context.getBeanDefinitionNames())
        .contains("factoryMethodDao", "instanceFactoryMethodDao", "constructorService");

    var service = context.getBean("constructorService", ConstructorService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("어플리케이션 컨텍스트 bean alias 테스트")
  void applicationContext_alias() {
    var context = new ClassPathXmlApplicationContext("services.xml");
    assertThat(context.getBeanDefinitionNames())
        .contains("factoryMethodDao", "instanceFactoryMethodDao", "constructorService");

    var service = context.getBean("aliasService", ConstructorService.class);
    assertThat(service.numbers())
        .hasSize(5)
        .containsExactly(1, 2, 3, 4, 5);
  }
}
