package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMin {

  public static int maxMin(int k, List<Integer> arr) {
    Collections.sort(arr);

    int temp = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.size() - k; i++) {
      int min = arr.get(i + k - 1) - arr.get(i);
      if (min < temp) {
        temp = min;
      }
    }

    return temp;
  }

  public static void main(String[] args) {
//    int n = 20;
//    int k = 5;
//
//    List<Integer> arr = Arrays.asList(4504,
//        1520,
//        5857,
//        4094,
//        4157,
//        3902,
//        822,
//        6643,
//        2422,
//        7288,
//        8245,
//        9948,
//        2822,
//        1784,
//        7802,
//        3142,
//        9739,
//        5629,
//        5413,
//        7232);

//    int result = maxMin(k, arr);
    int result = maxMin(3, Arrays.asList(100, 200, 300, 350, 400, 401, 402));
    System.out.println(result);
  }
}
