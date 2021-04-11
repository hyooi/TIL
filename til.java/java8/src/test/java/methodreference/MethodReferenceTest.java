package methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodReferenceTest {

  @Test
  @DisplayName("정적 메소드 참조")
  void static_method_reference() {
    var integers = Arrays.asList(1, 12, 433, 5);
    var max = integers.stream().reduce(Math::max);

    max.ifPresent(val -> System.out.println(val));
  }

  @Test
  @DisplayName("인스턴스의 인스턴스 메소드 참조")
  void instance_method_in_instance_reference() {
    var integers = Arrays.asList(1, 12, 433, 5);
    var max = integers.stream().reduce(Math::max);

    max.ifPresent(System.out::println);
  }

  @Test
  @DisplayName("클래스의 인스턴스 메소드 참조")
  void instance_method_in_class_reference() {
    var strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
    var sorted = strings.stream()
        .sorted((s1, s2) -> s1.compareTo(s2))
        .collect(Collectors.toList());

    System.out.println(sorted);

    var sortedAlt = strings.stream()
        .sorted(String::compareTo)
        .collect(Collectors.toList());

    System.out.println(sortedAlt);
  }

  @Test
  @DisplayName("생성자 참조")
  void constructor_reference() {
    var integers = IntStream.range(1, 100)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));

    var max = integers.stream()
        .reduce(Math::max);

    max.ifPresent(System.out::println);
  }
}
