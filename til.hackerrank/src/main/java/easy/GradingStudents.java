package easy;

import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
  public static List<Integer> gradingStudents(List<Integer> grades) {
    return grades.stream()
        .map(grade -> {
          if (grade < 37) {
            return grade;
          }

          int nextMultiple = ((grade / 5) + 1) * 5;
          return nextMultiple - grade < 3? nextMultiple : grade;
        })
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(gradingStudents(List.of(73, 67, 38, 33)));
  }
}
