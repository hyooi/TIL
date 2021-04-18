import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("repeat")
  void repeat() {
    Assertions.assertEquals("11111", "1".repeat(5));
  }

  @Test
  @DisplayName("문자열 비어있는지 여부 확인")
  void isBlank() {
    Assertions.assertFalse("1".isBlank());
    Assertions.assertTrue("".isBlank());
    Assertions.assertTrue("  ".isBlank());
  }

  @Test
  @DisplayName("multi line 텍스트를 stream으로 처리")
  void multi_line_text() {
    var lines = new ArrayList<String>();
    "hello\nworld\nis\nexecutes".lines()
        .forEach(lines::add);

    Assertions.assertEquals(List.of("hello", "world", "is", "executes"), lines);
  }

}
