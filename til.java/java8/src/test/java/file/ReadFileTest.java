package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadFileTest {

  @Test
  @SneakyThrows
  @DisplayName("한줄씩 파일 읽기")
  void read_file() {
    Path filePath = Paths.get("src/test/resources", "data.txt");
    try (var lines = Files.lines(filePath)) {
      lines.forEach(System.out::println);
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("한줄씩 파일 읽기(with 필터링)")
  void read_file_with_filtering() {
    Path filePath = Paths.get("src/test/resources", "data.txt");
    try (var lines = Files.lines(filePath)) {
      var filteredLines = lines.filter(s -> s.contains("password"))
          .collect(Collectors.toList());

      filteredLines.forEach(System.out::println);
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("java7 파일읽기")
  void read_file_java7() {
    var file = new File("src/test/resources/data/txt");
    var fr = new FileReader(file);
    var br = new BufferedReader(fr);

    String line;
    while ((line = br.readLine()) != null) {
      if (line.contains("password")) {
        System.out.println(line);
      }
    }

    br.close();
    fr.close();
  }
}
