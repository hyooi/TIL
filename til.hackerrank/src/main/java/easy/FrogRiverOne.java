package easy;

public class FrogRiverOne {

  public static int solution(int X, int[] A) {
    boolean[] arr = new boolean[X + 1];

    for (int i = 0; i < A.length; i++) {
      if (!arr[A[i]]) {
        arr[A[i]] = true;
        X--;

        if (X == 0) {
          return i;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(FrogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    System.out.println(FrogRiverOne.solution(1, new int[]{3, 3, 4, 4, 2, 3, 5, 4}));
  }
}
