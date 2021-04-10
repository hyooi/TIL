package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Java9 {

  @Test
  @DisplayName("takewhile예제")
  void takeWhile() {
    var alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");
    var subset1 = alphabets.stream()
        .takeWhile(s -> !s.equals("d"))
        .collect(Collectors.toList());

    System.out.println(subset1);
  }

  @Test
  @DisplayName("dropwhile예제")
  void dropwhile() {
    var alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");
    var subset1 = alphabets.stream()
        .dropWhile(s -> !s.equals("d"))
        .collect(Collectors.toList());

    System.out.println(subset1);
  }

  @Test
  @DisplayName("반복메소드")
  void iteartor() {
    var numbers = Stream.iterate(1, i -> i <= 10, i -> i + 1)
        .collect(Collectors.toList());

    System.out.println(numbers);
  }

  @Test
  @DisplayName("ofnullable")
  void ofNullable() {
    var stream = Stream.ofNullable("123");
    System.out.println(stream.count());

    stream = Stream.ofNullable(null);
    System.out.println(stream.count());
  }
}
