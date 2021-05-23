package etc.codility;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTest1 {

  public static String solution(String T) {
    return Arrays.stream(T.split(""))
        .sorted(Comparator.reverseOrder())
        .reduce((s1, s2) -> s1 + s2)
        .get();
  }

  public static void main(String[] args) {
    System.out.println(CodingTest1.solution("MSSLS"));
    System.out.println(CodingTest1.solution("LLMS"));
    System.out.println(CodingTest1.solution("SMS"));
    System.out.println(CodingTest1.solution("S"));
  }
}
