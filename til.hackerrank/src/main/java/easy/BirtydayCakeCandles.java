package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BirtydayCakeCandles {
  /*
   * Complete the 'birthdayCakeCandles' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY candles as parameter.
   */

  public static int birthdayCakeCandles(List<Integer> candles) {
//    int max = candles.stream().max(Integer::compareTo).get();
    int max = Collections.max(candles);
    int maxCount = 0;
    for (Integer candle : candles) {
      if (max == candle) {
        maxCount++;
      }
    }

    return maxCount;
  }

  public static void main(String[] args) {
    List<Integer> candles = new ArrayList<>();
    candles.add(4);
    candles.add(4);
    candles.add(1);
    candles.add(3);

    System.out.println(birthdayCakeCandles(candles));
  }
}
