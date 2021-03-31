package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinMaxCountTest {

  @Test
  @DisplayName("스트림에서 가장 작은요소 찾기")
  void min_element() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    System.out.println(list.stream()
        .min(Integer::compareTo)
        .get()
    );
  }

  @Test
  @DisplayName("comparator를 활용한 작은요소 찾기")
  void min_element_with_comparator() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    var minComparator = new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };

    System.out.println(list.stream()
        .min(minComparator)
        .get()
    );
  }

  @Test
  @DisplayName("스트림에서 가장 큰 요소 찾기")
  void max_element() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    System.out.println(list.stream()
        .max(Integer::compareTo)
        .get()
    );
  }

  @Test
  @DisplayName("comparator를 활용한 큰요소 찾기")
  void max_element_with_comparator() {
    var list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
    var maxComparator = new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };

    System.out.println(list.stream()
        .max(maxComparator)
        .get()
    );
  }

  @Test
  @DisplayName("stream으로 숫자count")
  void count_list_number() {
    System.out.println(Stream.of("how", "to", "do", "in", "java")
        .count()
    );

    System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .count()
    );

    System.out.println(LongStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .filter(i -> i % 2 == 0)
        .count()
    );

  }

  @Test
  @DisplayName("collectors.counting으로 숫자count")
  void count_list_number_with_collector() {
    System.out.println(Stream.of("how", "to", "do", "in", "java")
        .collect(Collectors.counting())
    );

    System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .collect(Collectors.counting())
    );

    System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .filter(i -> i % 2 == 0)
        .collect(Collectors.counting())
    );

  }
}
