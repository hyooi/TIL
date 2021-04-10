package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 서로 다른 스트림을 연결함 둘 중 하나가 병렬이면 결과 스트림은 병렬 결과 스트림이 닫히면 둘다 닫히게 됨
 */
public class ConcatTest {

  @Test
  @DisplayName("두개 java스트림 병합")
  void merge_with_streams() {
    var firstStream = Stream.of(1, 2, 3);
    var secondStream = Stream.of(4, 5, 6);

    var resultStream = Stream.concat(firstStream, secondStream);
    System.out.println(resultStream.collect(Collectors.toList()));
  }

  @Test
  @DisplayName("두개 java스트림 병합2")
  void merge_with_streams2() {
    var first = Stream.of(1, 2);
    var second = Stream.of(3, 4);
    var third = Stream.of(5, 6);
    var fourth = Stream.of(7, 8);

    var resultStream = Stream.concat(first, Stream.concat(second, Stream.concat(third, fourth)));
    System.out.println(resultStream.collect(Collectors.toList()));
  }
}
