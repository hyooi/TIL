import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {

  private static final List<String> memberNames = Arrays.asList(
      "Amitabh", "Shekhar", "Aman",
      "Rahul", "Shahrukh", "Salman", "Yana", "Lokesh"
  );

  @Test
  @DisplayName("기본stream")
  void default_stream() {
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("array to stream")
  void array_to_stream() {
    Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("list to stream")
  void list_to_stream() {
    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .stream()
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("stream generate")
  void stream_generate() {
    Stream.generate(() -> (new Random()).nextInt(100))
        .limit(20)
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("Stream of String char or tokens")
  void string_char_or_tokens() {
    "12345_abcdfeg".chars()
        .forEach(System.out::println);

    Stream.of("A$B$C".split("\\$"))
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("collect stream elements to a list")
  void collect_stream_element() {
    var evenNumberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .stream()
        .filter(i -> i % 2 == 0)
        .collect(Collectors.toList());

    System.out.println(evenNumberList);
  }

  @Test
  @DisplayName("collect stream elements to an array")
  void collect_stream_element_to_an_array() {
    var evenNumberArr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .stream()
        .filter(i -> i % 2 == 0)
        .toArray(Integer[]::new);

    System.out.println(Arrays.toString(evenNumberArr));
  }

  @Test
  @DisplayName("stream filter")
  void stream_filter() {
    memberNames.stream()
        .filter(s -> s.startsWith("A"))
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("function을 통해 다른 객체로 스트림 변환")
  void stream_map() {
    memberNames.stream()
        .filter(s -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("stream정렬 및 collect")
  void stream_sort() {
    memberNames.stream()
        .sorted()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("stream match")
  void stream_match() {
    System.out.println(memberNames.stream()
        .anyMatch(s -> s.startsWith("A"))); //A로 시작하는 값을 찾으면 즉시 스트림 종료

    System.out.println(memberNames.stream()
        .allMatch(s -> s.startsWith("A")));

    System.out.println(memberNames.stream()
        .noneMatch(s -> s.startsWith("A")));
  }

  @Test
  @DisplayName("stream count")
  void stream_count() {
    System.out.println(memberNames.stream()
        .filter(s -> s.startsWith("A"))
        .count());
  }

  @Test
  @DisplayName("stream reduce")
  void stream_reduce() {
    var reduced = memberNames.stream()
        .reduce((s1, s2) -> s1 + "#" + s2);
    reduced.ifPresent(System.out::println);
  }

  @Test
  @DisplayName("stream findfirst")
  void stream_findfirst() {
    System.out.println(memberNames.stream()
        .filter(s -> s.startsWith("L"))
        .findFirst() //첫번째 요소 반환 후 더이상 스트림 처리X
        .get());
  }

  @Test
  @DisplayName("stream distinct")
//stream distinct는 중복element를 찾기 위해 equals를 사용함
  void stream_distinct() {
    var lokesh = new Person(1, "Lokesh", "Gupta");
    var brian = new Person(2, "Brian", "Clooney");
    var alex = new Person(3, "Alex", "Kolen");

    var list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);
    var distinctElements = list.stream()
        .filter(distinctByKey(Person::getId))
        .collect(Collectors.toList());

    System.out.println(distinctElements);
  }

  private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
    var map = new ConcurrentHashMap<>();
    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }

  @AllArgsConstructor
  @ToString
  @Getter
  private static class Person {

    private Integer id;
    private String fname;
    private String lname;
  }

}
