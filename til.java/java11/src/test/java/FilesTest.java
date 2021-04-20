import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilesTest {

  @Test
  @SneakyThrows
  @DisplayName("파일읽기")
    //readString은 파일이 2gb이상이면 oom발생
  void read_file() {
    var txtFileUri = getClass().getClassLoader().getResource("temp.log").toURI();
    System.out.println(Files.readString(Path.of(txtFileUri), Charset.defaultCharset()));
  }

  @Test
  @SneakyThrows
  @DisplayName("파일쓰기")
  void write_file() {
    var tmpFilePath = Path.of(File.createTempFile("tempFile", ".tmp").toURI());
    var returnFilePath = Files.writeString(tmpFilePath, "hello wrold",
        Charset.defaultCharset(), StandardOpenOption.WRITE);
  }
}
