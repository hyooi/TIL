package easy;

import java.util.ArrayList;
import java.util.List;
public class BreakingRecords {
  public static List<Integer> breakingRecords(List<Integer> scores) {
    int breakingMostPointsRecord = 0;
    int breakingLeastPointsRecord = 0;

    int nowMostPoint = scores.get(0);
    int nowLeastPoint = scores.get(0);
    for (int score : scores) {
      if (score > nowMostPoint) {
        nowMostPoint = score;
        breakingMostPointsRecord++;
      } else  if (score < nowLeastPoint) {
        nowLeastPoint = score;
        breakingLeastPointsRecord++;
      }
    }

    List<Integer> result = new ArrayList<>();
    result.add(breakingMostPointsRecord);
    result.add(breakingLeastPointsRecord);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1))); // 2 4
    System.out.println(breakingRecords(List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42))); // 4 0
  }
}
