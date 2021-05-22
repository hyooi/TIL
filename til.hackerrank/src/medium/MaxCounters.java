package medium;

import java.util.Arrays;

public class MaxCounters {

  public static int[] solution(int N, int[] A) {
    int[] result = new int[N];
    int max = 0;

    for (int a : A) {
      if (a == N + 1) {
        Arrays.fill(result, max);
      } else {
        result[a - 1]++;

        if (result[a - 1] > max) {
          max = result[a - 1];
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    System.out.println(Arrays.toString(MaxCounters.solution(5, new int[]{6, 4, 4, 6, 4, 4, 6})));
  }
}
