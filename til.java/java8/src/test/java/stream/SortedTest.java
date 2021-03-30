package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortedTest {

  @Test
  @DisplayName("기본sort")
  void natural_sort() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    System.out.println(list.stream()
        .sorted()
        .collect(Collectors.toList())
    );
  }

  @Test
  @DisplayName("역순sort")
  void reverse_sort() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    System.out.println(list.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList())
    );
  }

  @Test
  @DisplayName("custom sort")
  void custom_sort() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    System.out.println(list.stream()
        .sorted((i1, i2) -> i2.compareTo(i1))
        .collect(Collectors.toList()));
  }
}
