package easy;

import java.util.Arrays;
import java.util.List;

public class DivisibleSumPairs {

  // i <j, i번째 숫자, j번째 숫자를 더한 값이 k로 나눠져야함
  // return pair갯수
  public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    int result = 0;
    for (int i=0; i<ar.size(); i++) {
      for (int j=i+1; j<ar.size(); j++) {
        if ((ar.get(i) + ar.get(j)) % k ==0) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(divisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2))); //5
    // 0,2 / 0,5 / 1,3 / 2,4/ 4,5
  }
}
