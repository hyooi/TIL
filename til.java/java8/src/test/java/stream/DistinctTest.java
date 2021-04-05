package stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistinctTest {

  @Test
  @DisplayName("default distinct")
  void distinct() {
    var distinctedList = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8)
        .stream()
        .distinct()
        .collect(Collectors.toList());

    System.out.println(distinctedList);
  }

  @Test
  @DisplayName("distinct with toSet")
  void toSet() {
    var distinctedSet = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8)
        .stream()
        .collect(Collectors.toSet());

    System.out.println(distinctedSet);
  }

  @Test
  @DisplayName("발생횟수별 map with toMap")
  void toMap() {
    var elementCountMap = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8)
        .stream()
        .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

    System.out.println(elementCountMap);
  }
}
