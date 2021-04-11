package functionalinterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyFirstFunctionalInterfaceTest {

  @Test
  @DisplayName("functionalinterface.MyFirstFunctionalInterface")
  void MyFirstFunctionalInterface() {
    var interface01 = new MyFirstFunctionalInterface() {
      @Override
      public void firstWork() {
        System.out.println("firstWork!");
      }

      @Override
      public String toString() {
        return "tostring";
      }

      @Override
      public boolean equals(Object obj) {
        return false;
      }
    };

    interface01.firstWork();
    assertEquals("tostring", interface01.toString());
    assertNotEquals(interface01, null);
  }
}