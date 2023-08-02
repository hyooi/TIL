package easy;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DiagonalDifference {
  public static int diagonalDifference(List<List<Integer>> arr) {
    int leftToRight = 0;
    int rightToLeft = 0;

    for (int i=0; i < arr.size(); i++) {
      leftToRight += arr.get(i).get(i);
      rightToLeft += arr.get(i).get(arr.size() - (i+1));
    }

    return Math.abs(leftToRight - rightToLeft);
  }

  public static void main(String[] args) {
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(Stream.of("1 2 3".split(" "))
        .map(Integer::parseInt)
        .collect(toList()));
    arr.add(Stream.of("4 5 6".split(" "))
        .map(Integer::parseInt)
        .collect(toList()));
    arr.add(Stream.of("9 8 9".split(" "))
        .map(Integer::parseInt)
        .collect(toList()));

    int result = diagonalDifference(arr);
    System.out.println(result);
  }
}
