import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * record : 데이터 설정 및 가져올 때 필요한 상용구 코드를 제거함. immutable이며 final임 ex. 생성자, 게터, hashcode, equals
 */
public class RecordTest {

  @Test
  @DisplayName("record")
  void record() {
    var e1 = new EmployeeRecord(1L, "Lokesh", "Gupta", "1@gmail.com", 38);
    assertEquals(1L, e1.id());
    assertEquals("1@gmail.com", e1.email());

    System.out.println(e1);
  }

}
