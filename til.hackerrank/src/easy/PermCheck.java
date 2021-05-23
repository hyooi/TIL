package easy;

import java.util.Arrays;

public class PermCheck {

  public static int solution(int[] A) {
    Arrays.sort(A);

    int i = 1;
    for (int a : A) {
      if (i != a) {
        return 0;
      }

      i++;
    }

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(PermCheck.solution(new int[]{4, 1, 3, 2}));
    System.out.println(PermCheck.solution(new int[]{4, 1, 3}));
    System.out.println(PermCheck.solution(new int[]{4, 3}));
  }
}
