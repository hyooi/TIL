package easy;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
public class PlusMinus {
  public static void plusMinus(List<Integer> arr) {
    int positiveCnt = 0;
    int negativeCnt = 0;
    int zeroCnt = 0;

    for (int num : arr) {
      if (num == 0) {
        zeroCnt++;
        continue;
      }

      if (num > 0) {
        positiveCnt++;
      } else {
        negativeCnt++;
      }
    }

    double size = arr.size() * 1.0;
    System.out.printf("%.6f%n", positiveCnt / size);
    System.out.printf("%.6f%n", negativeCnt / size);
    System.out.printf("%.6f%n", zeroCnt / size);
  }

  public static void main(String[] args) throws IOException {
    List<Integer> arr = Stream.of("1 1 0 -1 -1".split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    plusMinus(arr);
  }
}
