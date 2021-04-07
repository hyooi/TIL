package stream;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
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

  @Test
  @DisplayName("distinctbykey")
  void distinctByKey() {
    var lokesh = new Person(1, "Lokesh", "Gupta");
    var brian = new Person(2, "Brian", "Clooney");
    var alex = new Person(3, "Alex", "Kolen");

    var list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);

    var distinctElement = list.stream()
        .filter(distinctByKey2(Person::getId))
        .collect(Collectors.toList());

    System.out.println(distinctElement);
  }

  private <T> Predicate<T> distinctByKey2(Function<? super T, Object> keyExtractor) {
    var map = new ConcurrentHashMap<>();
    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }

  @Test
  @DisplayName("distinctByKeys")
  void distinctByKeys() {
    var recordList = Arrays.asList(
        new Person(1, "Lokesh1", "Gupta"),
        new Person(1, "Lokesh1", "Gupta"),
        new Person(2, "Lokesh2", "Gupta"),
        new Person(2, "Lokesh2", "Gupta"),
        new Person(3, "Lokesh3", "Gupta"));

    var list = recordList.stream()
        .filter(distinctByKeys(Person::getId, Person::getFname))
        .collect(Collectors.toList());

    System.out.println(list);
  }

  private <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
    var seen = new ConcurrentHashMap<>();
    return t -> {
      var keys = Arrays.stream(keyExtractors)
          .map(key -> key.apply(t))
          .collect(Collectors.toList());

      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
  }

  @AllArgsConstructor
  @ToString
  @Getter
  private static class Person {

    private final Integer id;
    private final String fname;
    private final String lname;
  }


}
