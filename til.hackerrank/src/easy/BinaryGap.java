package easy;

public class BinaryGap {

  public static int solution(int N) {
    String[] binary = Integer.toBinaryString(N).split("");
    int max = Integer.MIN_VALUE;
    int cnt = 0;
    for (String s : binary) {
      if ("1".equals(s)) {
        if (max < cnt) {
          max = cnt;
        }
        cnt = 0;
      } else {
        cnt++;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(BinaryGap.solution(1041));
  }
}
