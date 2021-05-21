package easy;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

  public static int sol(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int a : A) {
      set.add(a);
    }

    return set.size();
  }

  public static void main(String[] args) {
    System.out.println(Distinct.sol(new int[]{2, 1, 1, 2, 3, 1}));
  }
}
