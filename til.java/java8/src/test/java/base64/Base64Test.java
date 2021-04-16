package base64;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Base64? 이진 데이터를 64개의 ascii코드로 변환함 ex.email메시지, 기본 http authentication
 */
public class Base64Test {

  @Test
  @DisplayName("문자열 -> base64")
  void encoding_string_to_base64() {
    Assertions.assertEquals("dXNlcm5hbWU6cGFzc3dvcmQ=", Base64.getEncoder()
        .encodeToString("username:password".getBytes(StandardCharsets.UTF_8)));
  }

  @Test
  @DisplayName("base64 -> 문자열")
  void decoding_base64_to_string() {
    Assertions.assertEquals("username:password", new String(Base64.getDecoder()
        .decode("dXNlcm5hbWU6cGFzc3dvcmQ=")));
  }

  @Test
  @SneakyThrows
  @DisplayName("base64인코딩해 outputstream으로 내보내기")
  void encoding_with_outputstream() {
    try (var output = Files.newOutputStream(Paths.get("src/test/resources", "output.log"))) {
      Files.copy(Paths.get("src/test/resources", "data.txt"), Base64.getMimeEncoder().wrap(output));
      var encodedStream = Base64.getMimeEncoder().wrap(output);
    }
  }
}
