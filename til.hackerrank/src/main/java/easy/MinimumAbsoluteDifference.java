package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {

  public static int minimumAbsoluteDifference(List<Integer> arr) {
    Collections.sort(arr);
    
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.size() - 1; i++) {
      int temp = Math.abs(arr.get(i) - arr.get(i + 1));
      if (temp < min) {
        min = temp;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    int n = 3;
    List<Integer> arr = Arrays.asList(3, -7, 0);

    int result = MinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
    System.out.println(result);
  }
}
