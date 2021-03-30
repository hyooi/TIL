import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamMapTest {

  @Test
  @DisplayName("list의 값에서 salary만 조회")
  void distinct_salary() {
    var employeesList = Arrays.asList(
        new Employee(1, "Alex", 100),
        new Employee(2, "Brian", 100),
        new Employee(3, "Charles", 200),
        new Employee(4, "David", 200),
        new Employee(5, "Edward", 300),
        new Employee(6, "Frank", 300)
    );

    System.out.println(employeesList.stream()
        .map(Employee::getSalary)
        .distinct()
        .collect(Collectors.toList())
    );
  }

  @AllArgsConstructor
  @Getter
  private static class Employee {

    private final int id;
    private final String name;
    private final int salary;
  }

  @Test
  @DisplayName("nested list를 list로 변환")
  void convert_nested_list_into_list() {
    var list1 = Arrays.asList(1, 2, 3);
    var list2 = Arrays.asList(4, 5, 6);
    var list3 = Arrays.asList(7, 8, 9);

    var listOfLists = Arrays.asList(list1, list2, list3);

    System.out.println(listOfLists.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList())
    );
  }

  @Test
  @DisplayName("nested list를 list로 변환2")
  void convert_nested_list_into_list2() {
    var dataArray = new String[][]{
        {"a", "b"}, {"c", "d"},
        {"e", "f"}, {"g", "h"}
    };

    System.out.println(Arrays.stream(dataArray)
        .flatMap(Arrays::stream)
        .collect(Collectors.toList())
    );
  }
}
