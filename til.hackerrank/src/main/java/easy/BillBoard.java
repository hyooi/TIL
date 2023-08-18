package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BillBoard {
  private final static Map<String, boolean[]> MAP = new HashMap<>();
  static {
    MAP.put("0", new boolean[] {true, true, true, true, true, true, false});
    MAP.put("1", new boolean[] {false, false, true, true, false, false, false});
    MAP.put("2", new boolean[] {false, true, true, false, true, true, true});
    MAP.put("3", new boolean[] {false, true, true, true, true, false, true});
    MAP.put("4", new boolean[] {true, false, true, true, false, false, true});
    MAP.put("5", new boolean[] {true, true, false, true, true, false, true});
    MAP.put("6", new boolean[] {true, true, false, true, true, true, true});
    MAP.put("7", new boolean[] {true, true, true, true, false, false, false});
    MAP.put("8", new boolean[] {true, true, true, true, true, true, true});
    MAP.put("9", new boolean[] {true, true, true, true, true, false, true});
    MAP.put("N", new boolean[] {false, false, false, false, false, false, false});
  }

  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    String testCaseCnt = scan.nextLine();

    for (int i=0; i<Integer.parseInt(testCaseCnt); i++) {
      String[] number = scan.nextLine().split(" ");
      String[] tempA = number[0].split("");
      String[] tempB = number[1].split("");

      number[0] = "N".repeat(5 - tempA.length) + number[0];
      number[1] = "N".repeat(5 - tempB.length) + number[1];

      tempA = number[0].split("");
      tempB = number[1].split("");

      int sum = 0;
      for (int j=0; j<5; j++) {
        sum += diff(tempA[j], tempB[j]);
      }

      System.out.println(sum);
    }

    scan.close();
  }

  private static int diff(String a, String b) {
    int result = 0;
    for(int i=0; i<7; i++) {
      if (MAP.get(a)[i] != MAP.get(b)[i]) {
        result++;
      }
    }

    return result;
  }
}
