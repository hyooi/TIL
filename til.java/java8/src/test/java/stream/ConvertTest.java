package stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertTest {

  @Test
  @DisplayName("unique map keys")
  void convert_map() {
    var employeeList = Arrays.asList(
        new Employee(1, "A", 100),
        new Employee(1, "A", 100),
        new Employee(2, "A", 200),
        new Employee(3, "B", 300),
        new Employee(4, "B", 400),
        new Employee(5, "C", 500),
        new Employee(5, "C", 500),
        new Employee(6, "C", 600)
    );

    System.out.println(employeeList.stream()
        .collect(Collectors.toMap(Employee::getNo, Function.identity(), (first, second) -> first)));
  }

  @Test
  @DisplayName("duplicate map keys")
  void convert_duplicate_map() {
    var employeeList = Arrays.asList(new Employee(1, "A", 100),
        new Employee(2, "A", 200),
        new Employee(3, "B", 300),
        new Employee(4, "B", 400),
        new Employee(5, "C", 500),
        new Employee(6, "C", 600)
    );

    System.out.println(employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getName)));
  }

  @Test
  @DisplayName("convert stream of strings to array")
  void convert_array() {
    var tokenStream = Arrays.asList("A", "B", "C", "D").stream();
    var tokenArray = tokenStream.toArray(String[]::new);

    System.out.println(Arrays.toString(tokenArray));
  }

  @Test
  @DisplayName("convert infinite stream to array")
  void convert_infinite_stream_to_array() {
    var infiniteNumberStream = IntStream.iterate(1, i -> i + 1);
    var intArray = infiniteNumberStream.limit(10)
        .toArray();

    System.out.println(Arrays.toString(intArray));
  }

  @Test
  @DisplayName("convert_infinite_stream_to_array_with boxing")
  void convert_infinite_stream_to_array_with_boxing() {
    var infiniteNumberStream = IntStream.iterate(1, i -> i + 1);
    var intArray = infiniteNumberStream.limit(10)
        .boxed()
        .toArray(Integer[]::new);

    System.out.println(Arrays.toString(intArray));
  }

  @Test
  @DisplayName("convert stream to array with filtering")
  void convert_stream_to_array_with_filitering() {
    var employeeList = Arrays.asList(new Employee(1, "A", 100),
        new Employee(2, "B", 200),
        new Employee(3, "C", 300),
        new Employee(4, "D", 400),
        new Employee(5, "E", 500),
        new Employee(6, "F", 600));

    var employeesArray = employeeList.stream()
        .filter(e -> e.getSalary() < 400)
        .toArray(Employee[]::new);

    System.out.println(Arrays.toString(employeesArray));
  }

  @Test
  @DisplayName("string stream을 list로 변환")
  void convert_string_steam_to_list() {
    var tokenStream = Stream.of("A", "B", "C", "D");
    var tokenList = tokenStream.collect(Collectors.toList());

    System.out.println(tokenList);
  }

  @Test
  @DisplayName("string stream을 linkedlist로 변환")
  void convert_string_steam_to_linkedlist() {
    var tokenStream = Stream.of("A", "B", "C", "D");
    var tokenList = tokenStream.collect(Collectors.toCollection(LinkedList::new));

    System.out.println(tokenList);
  }

  @Test
  @DisplayName("iterable을 stream으로 변환")
  void iterable_to_stream() {
    var iterable = Arrays.asList("A", "B", "C");
    var stream = StreamSupport.stream(iterable.spliterator(), false);

    stream.forEach(System.out::println);
  }

  @Test
  @DisplayName("iterator를 stream으로 변환")
  void iterator_to_stream() {
    var iterator = Arrays.asList("a", "b", "c").listIterator();
    var splitItr = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);

    StreamSupport.stream(splitItr, false)
        .forEach(System.out::println);
  }

  @Test
  @DisplayName("java9 iterator반복")
  void iterator_to_stream_java9() {
    var iterator = Arrays.asList("a", "b", "c").listIterator();
    Stream.generate(() -> null)
        .takeWhile(x -> iterator.hasNext())
        .map(n -> iterator.next())
        .forEach(System.out::println);
  }

  @Data
  private static class Employee {

    private final int no;
    private final String name;
    private final int salary;
  }
}
