package kello.ioc.beans;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import kello.ioc.beans.dependency.CollectionBean;
import kello.ioc.beans.dependency.MethodReplacementBean;
import kello.ioc.beans.dependency.NullBean;
import kello.ioc.beans.dependency.OuterBean;
import kello.ioc.beans.dependency.PropertyBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyConfigurationTest {

  @Test
  @DisplayName("빈생성 시 Properties 주입")
  void property_test() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var propertyBean = context.getBean("propertyBean", PropertyBean.class);

    assertThat(propertyBean.getProperty("jdbc.driver.className"))
        .isEqualTo("com.mysql.jdbc.Driver");
    assertThat(propertyBean.getProperty("jdbc.url"))
        .isEqualTo("jdbc:mysql://localhost:3306/mydb");
  }

  @Test
  @DisplayName("외부 빈에서 내부 빈 정의")
  void inner_bean_test() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var outerBean = context.getBean("outerBean", OuterBean.class);

    assertThat(outerBean.getKey()).isEqualTo("value01");
  }

  @Test
  /**
   * list -> arraylist, map -> LinkedHashMap, set -> LinkedHashSet으로 변환됨
   *
   */
  @DisplayName("빈 생성 시 컬렉션 주입")
  void collection_test() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var collectionBean = context.getBean("collectionBean", CollectionBean.class);

    assertThat(collectionBean.getList())
        .hasSize(1)
        .containsExactly("list01");

    assertThat(collectionBean.getMap())
        .hasSize(1)
        .containsExactly(entry("key01", "map01"));

    assertThat(collectionBean.getSet())
        .hasSize(1)
        .containsExactly("set01");
  }

  @Test
  @DisplayName("컬렉션 병합")
  void collection_merge_test() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var collection = context.getBean("childCollection", CollectionBean.class);

    assertThat(collection.getList())
        .hasSize(2)
        .containsExactly("list01", "list02");
  }

  @Test
  @DisplayName("Null주입")
  void null_injection_test() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var nullBean = context.getBean("nullBean", NullBean.class);

    assertThat(nullBean.getExample01()).isEqualTo("");
    assertThat(nullBean.getExample02()).isNull();
  }

  @Test
  @DisplayName("Method replacement-실제 메소드 대신 다른 메소드로 교체함")
  void replace_method() {
    var context = new ClassPathXmlApplicationContext("dependencyConfiguration.xml");
    var bean = context.getBean("methodReplacementBean", MethodReplacementBean.class);

    assertThat(bean.originalMethod("test"))
        .isEqualTo("[MethodReplacementBean2]test");
  }
}
