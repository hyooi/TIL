package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadFileTest {

  @Test
  @SneakyThrows
  @DisplayName("java8 read file")
  void read_file() {
    var filePath = Paths.get("src/test/resources/data.txt");

    try (Stream<String> lines = Files.lines(filePath)) {
      lines.forEach(System.out::println);
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("java8 read file-filtering")
  void read_file_filtering() {
    var filePath = Paths.get("src/test/resources/data.txt");
    try (Stream<String> lines = Files.lines(filePath)) {
      var filteredLines = lines.filter(s -> s.contains("password"))
          .collect(Collectors.toList());

      filteredLines.forEach(System.out::println);
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("java7 read file")
  void read_file_java7() {
    var file = new File("src/test/resources/data.txt");

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
