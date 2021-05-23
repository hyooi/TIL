package medium;

//FIXME 60%
public class MinAvgTwoSlice {

  public static int solution(int[] A) {
    double min = Integer.MAX_VALUE;
    int p = 0;
    for (int i = 0; i < A.length; i++) {
      int sum = A[i];
      for (int j = i + 1; j < A.length; j++) {
        sum += A[j];
        double temp = (double) sum / (j - i + 1);
        if (temp < min) {
          min = temp;
          p = i;
        }
      }
    }

    return p;
  }

  public static void main(String[] args) {
    System.out.println(MinAvgTwoSlice.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    System.out.println(MinAvgTwoSlice.solution(new int[]{4, 2}));
  }
}
