package medium;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyFlorist {

  static int getMinimumCost(int k, int[] c) {
    Integer[] tempArr = Arrays.stream(c)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .toArray(Integer[]::new);

    int price = 0;
    int s = 0;
    for (int i = 0; i < tempArr.length; i++) {
      if (i != 0 && i % k == 0) {
        s++;
      }

      price += (s + 1) * tempArr[i];
    }

    return price;
  }

  public static void main(String[] args) {
    int n = 5;
    int k = 3;
    int[] c = new int[]{1, 3, 5, 7, 9};

    int minimumCost = getMinimumCost(k, c);
    System.out.println(minimumCost);
  }
}
