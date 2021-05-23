package medium;

public class CountDiv {

  public static int solution(int A, int B, int K) {
    int result = B / K - A / K;
    return A % K == 0 ? result + 1 : result;
  }

  public static void main(String[] args) {
    System.out.println(CountDiv.solution(6, 12, 2));
    System.out.println(CountDiv.solution(6, 11, 2));
    System.out.println(CountDiv.solution(7, 10, 2));
    System.out.println(CountDiv.solution(6, 11, 1));
    System.out.println(CountDiv.solution(0, 0, 1));
    System.out.println(CountDiv.solution(1, 2, 1));
  }
}
