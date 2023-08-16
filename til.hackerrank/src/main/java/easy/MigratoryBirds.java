package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {
  public static int migratoryBirds(List<Integer> arr) {
    Map<Integer, Integer> birdTypeMap = new HashMap<>();
    arr.forEach(a -> {
          int cnt = birdTypeMap.getOrDefault(a, 1);
          birdTypeMap.put(a, cnt+1);
        });

    int result = -1;
    int max = -1;

    for (Map.Entry<Integer, Integer> e : birdTypeMap.entrySet()) {
      if (e.getValue() > max) {
        max = e.getValue();

        if (result != e.getKey()) {
          result = e.getKey();
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    System.out.println(migratoryBirds(List.of(1,1,2,2,3))); //1
    System.out.println(migratoryBirds(List.of(1, 4, 4, 4, 5, 3))); //4
    System.out.println(migratoryBirds(List.of(1, 2, 3, 4, 5,4,3,2,1,3,4))); //3
  }
}
