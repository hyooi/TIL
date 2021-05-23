package easy;

import java.util.Arrays;

// FIXME 84%
public class TapeEquilibrium {

  public static int solution(int[] A) {
    int result1 = A[0], result2 = Arrays.stream(A).sum() - A[0];
    int min = Math.abs(result1 - result2);

    if (A.length == 2) {
      return min;
    }

    for (int i = 1; i < A.length; i++) {
      result1 += A[i];
      result2 -= A[i];

      int result = Math.abs(result1 - result2);
      if (result < min) {
        min = result;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    System.out.println(TapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
    System.out.println(TapeEquilibrium.solution(new int[]{3, 1}));
    System.out.println(TapeEquilibrium.solution(new int[]{-1000, 1000}));
  }
}
