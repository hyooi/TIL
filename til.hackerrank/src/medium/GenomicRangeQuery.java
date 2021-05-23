package medium;

import java.util.Arrays;

// FIXME 62%
public class GenomicRangeQuery {

  public static int[] solution(String S, int[] P, int[] Q) {
    int[] result = new int[P.length];
    for (int i = 0; i < P.length; i++) {
      String temp = S.substring(P[i], Q[i] + 1);
      result[i] = getMinFactor(temp);
    }

    return result;
  }

  private static int getMinFactor(String temp) {
    if (temp.contains("A")) {
      return 1;
    }

    if (temp.contains("C")) {
      return 2;
    }

    if (temp.contains("G")) {
      return 3;
    }

    return 4;
  }

  /**
   * A:1 C:2 G:3 T:4
   *
   * @param args 아규먼트
   */
  public static void main(String[] args) {
    System.out.println(Arrays
        .toString(GenomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
  }

}
