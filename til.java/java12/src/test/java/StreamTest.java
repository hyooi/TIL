import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {

  @Test
  @DisplayName("최대, 최소급여 직원 찾기") // 두개의 컬렉터를 통합
  void teeing() {
    var employeeList = Arrays.asList(
        new Employee(1, "A", 100),
        new Employee(2, "B", 200),
        new Employee(3, "C", 300),
        new Employee(4, "D", 400)
    );

    var result = employeeList.stream()
        .collect(Collectors.teeing(
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            Collectors.minBy(Comparator.comparing(Employee::getSalary)),
            (e1, e2) -> {
              var map = new HashMap<>();
              map.put("MAX", e1.get());
              map.put("MIN", e2.get());

              return map;
            }
        ));

    System.out.println(result);
  }

  @Test
  @DisplayName("항목 필터링 및 count")
  void teeing_with_filtering_and_count() {
    var employeeList = Arrays.asList(
        new Employee(1, "A", 100),
        new Employee(2, "B", 200),
        new Employee(3, "C", 300),
        new Employee(4, "D", 400)
    );

    var result = employeeList.stream()
        .collect(Collectors.teeing(
            Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
            Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()),
            (list, count) -> {
              var map =new HashMap<>();
              map.put("list", list);
              map.put("count", count);

              return map;
            }
        ));

    System.out.println(result);
  }

  @Data
  private static class Employee {
    private final int no;
    private final String name;
    private final int salary;
  }
}
