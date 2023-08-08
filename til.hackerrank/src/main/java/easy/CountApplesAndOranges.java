package easy;

import java.util.Arrays;
import java.util.List;

public class CountApplesAndOranges {
  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    long falledApples = apples.stream()
        .map(l -> l + a)
        .filter(l -> l >= s && t >= l)
        .count();
    System.out.println(falledApples);

    long falledOranges = oranges.stream()
        .map(l -> l + b)
        .filter(l -> l >= s && t >= l)
        .count();
    System.out.println(falledOranges);
  }

  public static void main(String[] args) {
    countApplesAndOranges(7, 10, 4, 12, Arrays.asList(2, 3, -4), Arrays.asList(3, -2, -4)); // 1 2
    countApplesAndOranges(7, 11, 5, 15, Arrays.asList(-2, 2, 1), Arrays.asList(5, -6)); // 1 1
  }
}
