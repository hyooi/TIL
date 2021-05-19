package easy;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

  // FIXME 88%
  public static int solution(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : A) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }

    return map.entrySet()
        .stream()
        .filter(entry -> entry.getValue() % 2 == 1)
        .mapToInt(Map.Entry::getKey)
        .findFirst()
        .getAsInt();
  }

  public static void main(String[] args) {
    System.out.println(OddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
  }
}
