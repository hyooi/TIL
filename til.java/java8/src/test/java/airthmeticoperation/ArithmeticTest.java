package airthmeticoperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArithmeticTest {

  @Test
  @DisplayName("invalid result방지")
  void invalid_result() {
    System.out.println(100000 * 100000); //invalid result
    Assertions.assertThrows(ArithmeticException.class, () -> {
      Math.multiplyExact(100000, 100000); // 잘못된 계산을 미리 방지함
    });

    System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
    Assertions.assertThrows(ArithmeticException.class, () -> {
      Math.addExact(Integer.MAX_VALUE, Integer.MAX_VALUE);
    });
  }

  @Test
  @DisplayName("음수의 짝수홀수 파악")
  void mod_negative_number() {
    Assertions.assertEquals(0, 10 % 2);
    Assertions.assertEquals(1, 11 % 2);
    Assertions.assertEquals(-1, -15 % 2); //예측불가
    Assertions.assertEquals(0, -16 % 2); //예측불가

    Assertions.assertEquals(0, Math.floorMod(10, 2));
    Assertions.assertEquals(1, Math.floorMod(11, 2));
    Assertions.assertEquals(1, Math.floorMod(-15, 2));
    Assertions.assertEquals(0, Math.floorMod(-16, 2));
  }

  @Test
  @DisplayName("int에 long할당하기!")
  void assign_long_in_int() {
    System.out.println(Long.MAX_VALUE);
    System.out.println((int) Long.MAX_VALUE);
    System.out.println(Math.toIntExact(100000000));

    Assertions.assertThrows(ArithmeticException.class, () -> {
      System.out.println(Math.toIntExact(Long.MAX_VALUE));
    });
  }

  @Test
  @DisplayName("n보다 작은 숫자!")
  void less_then_number() {
    System.out.println(Math.nextDown(100));
    System.out.println(Math.nextDown(100.365));
  }
}
