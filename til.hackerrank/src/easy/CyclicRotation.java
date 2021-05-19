package easy;

import java.util.Arrays;

public class CyclicRotation {

  public static int[] solution(int[] A, int K) {
    int[] result = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      int point = (i + K) % A.length;
      result[point] = A[i];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(CyclicRotation.solution(new int[]{1, 2, 3}, 4)));
    System.out.println(Arrays.toString(CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3)));
    System.out.println(Arrays.toString(CyclicRotation.solution(new int[]{0, 0, 0}, 1)));
    System.out.println(Arrays.toString(CyclicRotation.solution(new int[]{1, 2, 3, 4}, 4)));
  }
}
