package easy;

public class Stock {

  public static int solution(int[] A) {
    if (A.length == 0) return 0;

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i=0; i<A.length; i++) {
      if (A[i] < min) {
        min = A[i];
      }

      if (A[A.length-i-1] > max) {
        max = A[A.length-i-1];
      }

      if (i == A.length/2) break;
    }

    return max - min;
  }

  /*
  최대이익
  a[5] - a[4] = 21367-21013 = 354
   */
  public static void main(String[] args) {
    System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367})); //356
    System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013})); //356
    System.out.println(solution(new int[]{0, 23171, 23171, 23171, 23171})); //356
    System.out.println(solution(new int[]{0,0,0}));
    System.out.println(solution(new int[]{}));
  }
}
