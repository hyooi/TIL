package etc.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTest4 {

  public static int solution(int[] prices, int[] discounts) {
    Integer[] sortedPrices = Arrays.stream(prices)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .toArray(Integer[]::new);

    Integer[] sortedDiscounts = Arrays.stream(discounts)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .toArray(Integer[]::new);

    int answer = 0;
    for (int i = 0; i < sortedPrices.length; i++) {
      answer += i < sortedDiscounts.length ? sortedPrices[i] * (100 - sortedDiscounts[i]) * 0.01
          : sortedPrices[i];
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(CodingTest4.solution(new int[]{13000, 88000, 10000}, new int[]{30, 20}));
    System.out.println(CodingTest4.solution(new int[]{32000, 18000, 42500}, new int[]{50, 20,
        65}));
  }
}
