package easy;

import java.util.List;

public class GetTotalX {
  public static int getTotalX(List<Integer> a, List<Integer> b) {
    int result = 0;

    int maxInA = a.stream().max(Integer::compareTo).get();
    int minInB = b.stream().min(Integer::compareTo).get();

    int value = maxInA;
    int count = 1;
    while (value <= minInB) {
      // value가 a의 요소들과도 % 0, b의 요소들과도 0이면 result+1
      int temp = value;
      long aCnt = a.stream().filter(v -> temp % v != 0).count();
      long bCnt = b.stream().filter(v -> v % temp != 0).count();

      if (aCnt ==0 && bCnt ==0) {
        result++;
      }

      count++;
      value = maxInA * count;
    }

    return result;
  }

  public static void main(String[] args) {
    // 리스트 a의 max숫자부터 리스트 b의 min숫자 사이의 값들 중 값 % a의요소들 == 0 이면서 b의 요소들 % 값 == 0인 갯수
    System.out.println(getTotalX(List.of(2, 4), List.of(16, 32, 96))); // 3 (4 8 16)
    System.out.println(getTotalX(List.of(2, 6), List.of(24, 36))); //2 (6, 12)
    System.out.println(getTotalX(List.of(2, 3, 6), List.of(42, 84))); //2
  }
}
