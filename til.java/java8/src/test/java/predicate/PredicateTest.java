package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PredicateTest {

  @Test
  @DisplayName("predicate test")
  void test() {
    var employees = Arrays.asList(
        new Employee(1, 23, "M", "Rick", "Beethovan"),
        new Employee(2, 13, "F", "Martina", "Hengis"),
        new Employee(3, 43, "M", "Ricky", "Martin"),
        new Employee(4, 26, "M", "Jon", "Lowman"),
        new Employee(5, 19, "F", "Cristine", "Maria"),
        new Employee(6, 15, "M", "David", "Feezor"),
        new Employee(7, 68, "F", "Melissa", "Roy"),
        new Employee(8, 79, "M", "Alex", "Gussin"),
        new Employee(9, 15, "F", "Neetu", "Singh"),
        new Employee(10, 45, "M", "Naveen", "Jain"));

    System.out
        .println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAdultMale()));
    System.out
        .println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAdultFemale()));
    System.out.println(EmployeePredicate.filterEmployees(employees,
        EmployeePredicate.isAgeMoreThan(35)));
    System.out.println(EmployeePredicate.filterEmployees(employees,
        EmployeePredicate.isAgeMoreThan(35).negate()));
  }

  private static class EmployeePredicate {

    public static Predicate<Employee> isAdultMale() {
      return p -> p.getAge() > 21 && p.getGender().equals("M");
    }

    public static Predicate<Employee> isAdultFemale() {
      return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
      return p -> p.getAge() > age;
    }

    public static List<Employee> filterEmployees(List<Employee> employees,
        Predicate<Employee> predicate) {
      return employees.stream()
          .filter(predicate)
          .collect(Collectors.toList());
    }
  }

  @Data
  private static class Employee {

    private final Integer id;
    private final Integer age;
    private final String gender;
    private final String firstName;
    private final String lastName;
  }
}
