package easy;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.StreamSupport;

public class StairCase {
  /*
   * Complete the 'staircase' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static void staircase(int n) {
    for (int i=0; i<n; i++) {
      StringBuilder blank = new StringBuilder();
      for (int j=n-i-1; j > 0; j--) {
        blank.append(" ");
      }

      StringBuilder sharp = new StringBuilder();
      for (int k=0; k < i+1; k++) {
        sharp.append("#");
      }
      System.out.println(blank.toString() + sharp.toString());
    }
  }

  public static void main(String[] args) {
    staircase(4);
  }
}
