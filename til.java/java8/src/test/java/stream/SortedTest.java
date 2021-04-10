package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import lombok.Data;
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

  @Test
  @DisplayName("여러필드에 대한 정렬")
  void multiple_field_sort() {
    var employees = Arrays.asList(
        new Employee(2, "Lokesh", "Gupta"),
        new Employee(1, "Alex", "Gussin"),
        new Employee(4, "Brian", "Sux"),
        new Employee(5, "Neon", "Piper"),
        new Employee(3, "David", "Beckham"),
        new Employee(7, "Alex", "Beckham"),
        new Employee(6, "Brian", "Suxena"));

    var compareByName = Comparator.comparing(Employee::getFirstName)
        .thenComparing(Employee::getLastName);

    System.out.println(employees.stream()
        .sorted(compareByName)
        .collect(Collectors.toList()));
  }

  @Data
  private static class Employee {

    private final int no;
    private final String firstName;
    private final String lastName;
  }
}
