package easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MiniMaxSum {
  /*
   * Complete the 'miniMaxSum' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void miniMaxSum(List<Integer> arr) {
    BigInteger maxSum = BigInteger.valueOf(Long.MIN_VALUE);
    BigInteger minSum = BigInteger.valueOf(Long.MAX_VALUE);

    for (int i = 0; i < arr.size(); i++) {
      List<Integer> copyArr = new ArrayList<>(arr);
      copyArr.remove(i);

      BigInteger sum = BigInteger.valueOf(copyArr.get(0)).add(BigInteger.valueOf(copyArr.get(1)))
              .add(BigInteger.valueOf(copyArr.get(2))).add(BigInteger.valueOf(copyArr.get(3)));
      maxSum = sum.max(maxSum);
      minSum = sum.min(minSum);
    }

    System.out.println(minSum + " " + maxSum);
  }

    public static void main(String[] args){
      List<Integer> vals = new ArrayList();
//      vals.add(256741038);
//      vals.add(623958417);
//      vals.add(467905213);
//      vals.add(714532089);
//      vals.add(938071625);

      vals.add(942381765);
      vals.add(627450398);
      vals.add(954173620);
      vals.add(583762094);
      vals.add(236817490);

      miniMaxSum(vals);
    }
}
