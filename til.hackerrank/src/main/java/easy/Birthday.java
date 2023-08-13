package easy;

import java.util.List;

public class Birthday {
  // 조각 길이 = m
  // 세그먼트를 더한 값 = d
  public static int birthday(List<Integer> s, int d, int m) {
    int result = 0;
    for(int i=0; i<=s.size()-m; i++) {
      int sum = 0;
      for (int j=i; j<i+m; j++) {
        sum += s.get(j);
      }

      if (d == sum) {
        result++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(birthday(List.of(2, 2, 1, 3, 2), 4, 2)); // 2(2, 2), (1,3)
    System.out.println(birthday(List.of(1, 2, 1, 3, 2), 3, 2)); // 2(1, 2), (2,1)
    System.out.println(birthday(List.of(1, 1, 1, 1, 1, 1), 3, 2)); //0
    System.out.println(birthday(List.of(4), 4, 1)); //1
  }
}
