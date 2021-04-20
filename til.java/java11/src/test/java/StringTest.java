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
  @DisplayName("repeat with 정규식(자바10 이하)")
  void repeat_regular_expression() {
    Assertions.assertEquals("AbcAbcAbc", new String(new char[3])
        .replace("\0", "Abc"));
  }

  @Test
  @DisplayName("선행 및 후행 공백제거")
  void strip() {
    Assertions.assertEquals("Hello World !!", "  Hello World !!  ".strip());
    Assertions.assertEquals("Hello World !!  ", "  Hello World !!  ".stripLeading());
    Assertions.assertEquals("  Hello World !!", "  Hello World !!  ".stripTrailing());
  }

  @Test
  @DisplayName("문자열 비어있는지 여부 확인")
  void isBlank() {
    Assertions.assertFalse("1".isBlank());
    Assertions.assertTrue("".isBlank());
    Assertions.assertTrue("  ".isBlank());
  }

  @Test
  @DisplayName("문자열 비어있는지 여부 확인(문자열 길이 0이어야 함)")
  void isEmpty() {
    Assertions.assertFalse("1".isEmpty());
    Assertions.assertFalse(" ".isEmpty());
    Assertions.assertTrue("".isEmpty());
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
