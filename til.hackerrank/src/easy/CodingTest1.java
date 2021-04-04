package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingTest1 {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] arrs = new int[]{1, 3, 2, 5, 3, 1};
    for (int i : arrs) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    Integer[] result = map.keySet()
        .stream()
        .filter(k -> map.get(k) == 1)
        .toArray(Integer[]::new);

    System.out.println(Arrays.toString(result));
  }

}
