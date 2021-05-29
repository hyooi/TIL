package etc;

import java.util.List;

public class BinarySearch {

  public static void main(String[] args) {
    System.out.println(binarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 11));
  }

  /*
  - 정렬된 리스트의 속성을 이용 O(lon2n)
   */
  private static boolean binarySearch(List<Integer> numbers, final Integer value) {
    if (numbers == null || numbers.isEmpty()) {
      return false;
    }

    final Integer comparison = numbers.get(numbers.size() / 2);
    if (value.equals(comparison)) {
      return true;
    }

    if (value < comparison) {
      return binarySearch(numbers.subList(0, numbers.size() / 2), value);
    } else {
      return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
    }
  }
}
