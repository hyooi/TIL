package stream;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForEachOrderedTest {

  @Test
  @DisplayName("integer iterate")
  void iterateOverStream() {
    var list = Arrays.asList(2, 4, 6, 8, 10);
    list.stream()
        .parallel()
        .forEach(System.out::println);

    System.out.println();

    list.stream()
        .parallel()
        .forEachOrdered(System.out::println); //paralled와 함께 사용 시 병렬처리 이점 잃을 수 있음
  }

  @Test
  @DisplayName("stream iterator")
  void stream_iterator() {
    var list = Arrays.asList(2, 4, 6, 8, 10);
    list.stream()
        .forEachOrdered(System.out::println);
  }

  @Test
  @DisplayName("stream 역순 iterator")
  void stream_reverseOrder_iterator() {
    var list = Arrays.asList(2, 4, 6, 8, 10);
    list.stream()
        .sorted(Comparator.reverseOrder())
        .forEachOrdered(System.out::println);
  }
}
