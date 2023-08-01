package easy;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompareTheTriplets {
  /*
   * Complete the 'compareTriplets' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int alice = 0;
    int bob = 0;

    for (int i=0; i < a.size(); i++) {
      if (a.get(i) == b.get(i)) {
        continue;
      }

      if (a.get(i) > b.get(i)) {
        alice++;
      } else {
        bob++;
      }
    }

    List<Integer> result = new ArrayList<>();
    result.add(alice);
    result.add(bob);

    return result;
  }

  public static void main(String[] args) throws IOException {
    List<Integer> a = Stream.of("5 6 7".split(" "))
        .map(Integer::parseInt)
        .collect(toList());
//
    List<Integer> b = Stream.of("3 6 10".split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = compareTriplets(a, b);
    System.out.println(result);
  }
}
