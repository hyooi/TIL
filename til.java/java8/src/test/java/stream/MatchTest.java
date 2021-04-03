package stream;

import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchTest {

  @Test
  @DisplayName("기본 anyMatch")
  void anyMatch() {
    var stream = Stream.of("one", "two", "three", "four");
    System.out.println(stream.anyMatch(s -> s.contains("four")));
  }

  @Test
  @DisplayName("anyMatch : multi predicate")
  void anyMatch_multi_predicate() {
    Predicate<Employee> olderThan50 = e -> e.getAge() > 50;
    Predicate<Employee> earningMoreThan40K = e -> e.getSalary() > 90000;
    Predicate<Employee> combinedCondition = olderThan50.and(earningMoreThan40K);

    System.out.println(Stream.of(
        new Employee(1, "A", 46, 30000),
        new Employee(2, "B", 56, 30000),
        new Employee(3, "C", 42, 50000),
        new Employee(4, "D", 52, 50000),
        new Employee(5, "E", 32, 80000),
        new Employee(6, "F", 72, 80000))
        .anyMatch(combinedCondition));
  }

  @Test
  @DisplayName("기본 allMatch")
  void allMatch() {
    var stream = Stream.of("one", "two", "three", "four");
    System.out.println(stream.allMatch(s -> !s.contains("\\d+")));
  }

  @Test
  @DisplayName("allMatch : multi predicate")
  void allMatch_multi_predicate() {
    Predicate<Employee> olderThan50 = e -> e.getAge() > 50;
    Predicate<Employee> earningMoreThan40K = e -> e.getSalary() > 40_000;
    Predicate<Employee> combinedCondition = olderThan50.and(earningMoreThan40K);

    System.out.println(Stream.of(
        new Employee(1, "A", 46, 30000),
        new Employee(2, "B", 56, 30000),
        new Employee(3, "C", 42, 50000),
        new Employee(4, "D", 52, 50000),
        new Employee(5, "E", 32, 80000),
        new Employee(6, "F", 72, 80000))
        .allMatch(combinedCondition));
  }

  @Test
  @DisplayName("기본 noneMatch")
  void noneMatch() {
    var stream = Stream.of("one", "two", "three", "four");
    System.out.println(stream.noneMatch(s -> s.contains("\\d+")));
  }

  @Data
  private static class Employee {

    private final long id;
    private final String name;
    private final int age;
    private final double salary;
  }

}
