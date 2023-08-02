package easy;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


public class VeryBigSum {

  /*
   * Complete the 'aVeryBigSum' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER_ARRAY ar as parameter.
   */

  public static long aVeryBigSum(List<Long> ar) {
    long result = 0;
    for (long temp : ar) {
      result += temp;
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    List<Long> ar = Stream.of("1000000001 1000000002 1000000003 1000000004 1000000005".split(" "))
        .map(Long::parseLong)
        .collect(toList());

    long result = aVeryBigSum(ar);
    System.out.println(result);
  }
}
