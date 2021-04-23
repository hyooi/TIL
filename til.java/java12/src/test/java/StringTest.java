import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @SneakyThrows
  @DisplayName("indent")
  void indent() {
    /**
     * 양수 : 시작 부분에 공백 추가
     * 음수 : 시작 부분에서 공백 삭제
     */
    var file = Files.createTempFile("testOne", ".txt");
    Files.writeString(file, "ABC".indent(8), StandardOpenOption.APPEND);
    Files.writeString(file, "123".indent(8), StandardOpenOption.APPEND);
    Files.writeString(file, "XYZ".indent(8), StandardOpenOption.APPEND);

    var lines = Files.lines(file);
    lines.forEach(System.out::println);
  }
}
