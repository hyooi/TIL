package stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import lombok.Data;
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

  @Test
  @DisplayName("최소, 최대 날짜 찾기")
  void find_min_or_max_date() {
    var start = LocalDate.now();
    var end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

    var dates = Stream.iterate(start, date -> date.plusDays(1))
        .limit(ChronoUnit.DAYS.between(start, end))
        .collect(Collectors.toList());

    var maxDate = dates.stream()
        .max(Comparator.comparing(LocalDate::toEpochDay))
        .get();

    var minDate = dates.stream()
        .min(Comparator.comparing(LocalDate::toEpochDay))
        .get();

    System.out.println("minDate = " + minDate);
    System.out.println("maxDate = " + maxDate);
  }

  @Test
  @DisplayName("최소 또는 최대 숫자 찾기")
  void find_min_or_max_number() {
    var maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .max(Comparator.comparing(Integer::valueOf))
        .get();

    var minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .min(Comparator.comparing(Integer::valueOf))
        .get();

    System.out.println("minNumber = " + minNumber);
    System.out.println("maxNumber = " + maxNumber);
  }

  @Test
  @DisplayName("최소 또는 최대 문자열 찾기")
  void find_min_or_max_string() {
    var maxChar = Stream.of("H", "T", "D", "I", "J")
        .max(Comparator.comparing(String::valueOf))
        .get();

    var minChar = Stream.of("H", "T", "D", "I", "J")
        .min(Comparator.comparing(String::valueOf))
        .get();

    System.out.println("minChar = " + minChar);
    System.out.println("maxChar = " + maxChar);
  }

  @Test
  @DisplayName("최소 또는 최대 object 찾기")
  void find_min_or_max_object() {
    var employees = Arrays.asList(
        new Employee(1, "Lokesh", 36),
        new Employee(2, "Alex", 46),
        new Employee(3, "Brian", 52));

    var comparator = Comparator.comparing(Employee::getAge);
    Employee minObject = employees.stream().min(comparator).get();
    Employee maxObject = employees.stream().max(comparator).get();

    System.out.println("minObject = " + minObject);
    System.out.println("maxObject = " + maxObject);
  }

  @Data
  private static class Employee {

    private final int id;
    private final String name;
    private final int age;
  }
}
