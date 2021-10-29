package kello.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import java.beans.Introspector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BeanNameTest {

  @Test
  @DisplayName("기본 bean명 생성 테스트")
  public void default_bean_generation() {
    var result = Introspector.decapitalize("FirstDao");
    assertThat(result).isEqualTo("firstDao");
  }

  @Test
  @DisplayName("대문자 bean명 생성 테스트")
  public void capital_bean_generation() {
    var result = Introspector.decapitalize("FIrstDao");
    assertThat(result).isEqualTo("FIrstDao");
  }
}
