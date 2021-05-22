package medium;

import java.util.Arrays;

public class MaxCounters {

  public static int[] solution(int N, int[] A) {
    int[] result = new int[N];
    int max = 0;
    int maxCnt = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == N + 1) {
        maxCnt++;
      } else {
        result[A[i] - 1]++;

        if (result[A[i] - 1] > max) {
          max = result[A[i] - 1];
        }
      }

      if (i == A.length - 1) {
        for (int j = 0; i < result.length; j++) {
          result[j] += maxCnt;
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
