package etc;

public class Fibonacci {

  private static final long[] memo = new long[11];

  public static void main(String[] args) {
    System.out.println(fibonnacci(10));
  }

  /*
  동적계획법
  : 같은 문제들을 반복해서 푸는 경우, 매번 재계산하지 않고 값을 저장해두었다가 재사용
   */
  private static long fibonnacci(int n) {
    if (n <= 1) {
      return n;
    } else if (memo[n] != 0) {
      return memo[n];
    } else {
      memo[n] = fibonnacci(n - 1) + fibonnacci(n - 2);
      return memo[n];
    }
  }
}
