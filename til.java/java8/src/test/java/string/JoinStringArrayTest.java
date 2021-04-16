package string;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JoinStringArrayTest {

  @Test
  @DisplayName("문자열 결합")
  void join_string() {
    var joinedString = String.join(",", "how", "to", "do", "in", "java");
    Assertions.assertEquals("how,to,do,in,java", joinedString);
  }

  @Test
  @DisplayName("문자열list 결합")
  void join_string_list() {
    var strList = Arrays.asList("how", "to", "do", "in", "java");
    Assertions.assertEquals("how,to,do,in,java", String.join(",", strList));
  }

  @Test
  @DisplayName("문자열array 결합")
  void join_string_array() {
    var strArray = new String[]{"how", "to", "do", "in", "java"};
    Assertions.assertEquals("how,to,do,in,java", String.join(",", strArray));
  }

  @Test
  @DisplayName("stringjoiner")
  void join_with_stringjoiner() {
    var joiner = new StringJoiner(",", "[", "]");
    joiner.add("how")
        .add("to")
        .add("do")
        .add("in")
        .add("java");

    Assertions.assertEquals("[how,to,do,in,java]", joiner.toString());
  }

  @Test
  @DisplayName("join with collectors")
  void join_with_collectors_joining() {
    var numbers = Arrays.asList("how", "to", "do", "in", "java");
    var joinedString = numbers.stream()
        .collect(Collectors.joining(",", "[", "]"));

    Assertions.assertEquals("[how,to,do,in,java]", joinedString);
  }
}
