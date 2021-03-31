package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ToArrayTest {

  @Test
  @DisplayName("문자 스트림을 배열로 변환")
  void convert_string_stream_to_string_array() {
    var tokenStream = Arrays.asList("A", "B", "C", "D").stream();
    var tokenArray = tokenStream.toArray(String[]::new);

    System.out.println(Arrays.toString(tokenArray));
  }

  @Test
  @DisplayName("무한stream을 배열로 변환")
  void convert_inifinite_stream_to_array() {
    var infiniteNumberStream = IntStream.iterate(1, i -> i + 1);
    var intArray = infiniteNumberStream.limit(10)
        .toArray();

    System.out.println(Arrays.toString(intArray));
  }

  @Test
  @DisplayName("무한box stream을 배열로 변환")
  void convert_inifinite_box_stream_to_array() {
    var infiniteNumberStream = IntStream.iterate(1, i -> i + 1);
    var intArray = infiniteNumberStream.limit(10)
        .boxed()
        .toArray(Integer[]::new);

    System.out.println(Arrays.toString(intArray));
  }

  @Test
  @DisplayName("스트림filter와 collect로 배열변환")
  void stream_filter_and_collect_to_array() {
    var employeeList = new ArrayList<>(Arrays.asList(
        new Employee(1, "A", 100),
        new Employee(2, "B", 200),
        new Employee(3, "C", 300),
        new Employee(4, "D", 400),
        new Employee(5, "E", 500),
        new Employee(6, "F", 600))
    );

    var employeesArray = employeeList.stream()
        .filter(e -> e.getSalary() < 400)
        .toArray(Employee[]::new);

    System.out.println(Arrays.toString(employeesArray));
  }

  @AllArgsConstructor
  @Getter
  @ToString
  private static class Employee {

    private final int id;
    private final String name;
    private final int salary;
  }
}
