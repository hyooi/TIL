package file;

import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WriteFileTest {

  @Test
  @SneakyThrows
  @DisplayName("bufferedWriter로 파일쓰기")
  void write_file_with_bufferedReader() {
    var path = Paths.get("src/test/resources/output.log");
    try (var writer = Files.newBufferedWriter(path)) {
      writer.write("hello!");
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("files.write로 파일쓰기")
  void write_file() {
    Files.writeString(Paths.get("src/test/resources/output.log"),
        "hello!");
  }
}
