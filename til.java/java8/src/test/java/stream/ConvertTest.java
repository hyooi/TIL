package stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
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

  @Data
  private static class Employee {

    private final int no;
    private final String name;
    private final int salary;
  }
}
