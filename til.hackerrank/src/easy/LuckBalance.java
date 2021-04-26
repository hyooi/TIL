package easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LuckBalance {
  /*
   * Complete the 'luckBalance' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. 2D_INTEGER_ARRAY contests
   */

  public static int luckBalance(int k, List<List<Integer>> contests) {
    int sum = 0;
    List<Integer> importantContests = new ArrayList<>();

    for (List<Integer> contest : contests) {
      if (contest.get(1) == 0) {
        sum += contest.get(0);
      } else {
        importantContests.add(contest.get(0));
      }
    }

    importantContests.sort(Comparator.comparingInt(o -> o));
    for (int i = 0, j = 0; i < importantContests.size(); i++, j++) {
      if (j < importantContests.size() - k) {
        sum -= importantContests.get(i);
      } else {
        sum += importantContests.get(i);
      }
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    String[] firstMultipleInput = {"6", "3"};

    int n = Integer.parseInt(firstMultipleInput[0]);
    int k = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> contests = new ArrayList<>();
    contests.add(Arrays.asList(5, 1));
    contests.add(Arrays.asList(2, 1));
    contests.add(Arrays.asList(1, 1));
    contests.add(Arrays.asList(8, 1));
    contests.add(Arrays.asList(10, 0));
    contests.add(Arrays.asList(5, 0));

    int result = LuckBalance.luckBalance(k, contests);
    System.out.println(result);
  }


}
