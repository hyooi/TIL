package stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JoiningTest {

  @Test
  @DisplayName("문자열 스트림 결합")
  void string_joining() {
    var words = Arrays.asList("a", "b", "c", "d");

    System.out.println(words.stream()
        .collect(Collectors.joining()));
    System.out.println(words.stream()
        .collect(Collectors.joining(",")));
    System.out.println(words.stream()
        .collect(Collectors.joining(",", "{", "}")));
  }
}
