package kello.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import java.beans.Introspector;
import org.junit.jupiter.api.Test;

public class IntrospectorTest {

  @Test
  public void test() {
    var temp1 = Introspector.decapitalize("FirstDao");
    assertThat(temp1).isEqualTo("firstDao");

    var temp2 = Introspector.decapitalize("FIrstDao");
    assertThat(temp2).isEqualTo("FIrstDao");
  }
}
