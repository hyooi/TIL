package easy;

import java.util.Arrays;

public class PermMissingElem {

  public static int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 1; i <= A.length; i++) {
      if (A[i - 1] != i) {
        return i;
      }
    }

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(PermMissingElem.solution(new int[]{2, 3, 1, 5}));
    System.out.println(PermMissingElem.solution(new int[]{}));
  }
}
