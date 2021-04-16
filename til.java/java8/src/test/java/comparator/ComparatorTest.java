package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparatorTest {

  @Test
  @DisplayName("이름정렬")
  void sorting_by_name() {
    var employees = getEmployees();
    employees.sort(Comparator.comparing(Employee::getFirstName));

    System.out.println(employees);
  }

  @Test
  @DisplayName("이름역순정렬")
  void sorting_by_reverse_name() {
    var employees = getEmployees();
    employees.sort(Comparator.comparing(Employee::getFirstName).reversed());

    System.out.println(employees);
  }

  @Test
  @DisplayName("다수필드 정렬")
  void sorting_by_multiple_field() {
    var employees = getEmployees();
    employees.sort(Comparator.comparing(Employee::getFirstName)
        .thenComparing(Employee::getLastName));

    System.out.println(employees);
  }

  @Data
  private static class Employee {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
  }

  private static List<Employee> getEmployees() {
    return Arrays.asList(new Employee(6, "Yash", "Chopra", 25),
        new Employee(2, "Aman", "Sharma", 28),
        new Employee(3, "Aakash", "Yaadav", 52),
        new Employee(5, "David", "Kameron", 19),
        new Employee(4, "James", "Hedge", 72),
        new Employee(8, "Balaji", "Subbu", 88),
        new Employee(7, "Karan", "Johar", 59),
        new Employee(1, "Lokesh", "Gupta", 32),
        new Employee(9, "Vishu", "Bissi", 33),
        new Employee(10, "Lokesh", "Ramachandran", 60));
  }
}
