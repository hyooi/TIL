package medium;

import java.util.Arrays;

public class MissingInteger {

  public static int solution(int[] A) {
    Arrays.sort(A);

    int result = 1;
    int before = 0;

    for (int a : A) {
      if (a > 0 && before != a && result >= a) {
        result++;
      }
      before = a;
    }

    return result <= 0 ? 1 : result;
  }

  public static void main(String[] args) {
    System.out.println(MissingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));
    System.out.println(MissingInteger.solution(new int[]{1, 2, 3}));
    System.out.println(MissingInteger.solution(new int[]{-1, -3}));
    System.out.println(MissingInteger.solution(new int[]{3}));
  }
}
