package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileTest {

  @Test
  @SneakyThrows
  @DisplayName("모든 파일 및 하위 디렉토리")
  void file_list() {
    var files = Files.list(Paths.get(""))
        .map(Path::toFile)
        .collect(Collectors.toList());

    files.forEach(System.out::println);
  }

  @Test
  @SneakyThrows
  @DisplayName("일반 파일만 출력")
  void file_list2() {
    var files = Files.list(Paths.get(""))
        .filter(Files::isRegularFile)
        .map(Path::toFile)
        .collect(Collectors.toList());

    files.forEach(System.out::println);
  }

  @Test
  @SneakyThrows
  @DisplayName("모든 파일 및 디렉토리 조회(속도향상)")
  void file_list3() {
    for (Path path : Files.newDirectoryStream(Paths.get(""))) {
      System.out.println(path.normalize().getFileName());
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("모든 파일 조회(속도향상)")
  void file_list4() {
    for (Path path : Files.newDirectoryStream(Paths.get("")
        , path -> path.toFile().isFile())) {
      System.out.println(path.normalize().getFileName());
    }
  }

  @Test
  @SneakyThrows
  @DisplayName("특정 확장자의 모든 파일 목록")
  void file_list5() {
    var files = Files.list(Paths.get(""))
        .filter(Files::isRegularFile)
        .filter(path -> path.toString().endsWith(".gradle"))
        .map(Path::toFile)
        .collect(Collectors.toList());

    files.forEach(System.out::println);
  }

}
