package easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

  static int jumpingOnClouds(int[] c) {
    int jumpCnt = 0;
    int now = 0;
    
    while (true) {
      if (now == c.length - 1) {
        break;
      }

      if (now + 1 == c.length - 1) {
        jumpCnt++;
        break;
      }

      int next = c[now + 1];
      int doubleNext = c[now + 2];

      if (next == 0 && doubleNext == 0) {
        now += 2;
      } else if (next == 1 && doubleNext == 0) {
        now += 2;
      } else {
        now++;
      }

      jumpCnt++;
    }

    return jumpCnt;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

//    int[] c = {0, 0, 0, 1, 0, 0};
//    int[] c = {0, 0, 1, 0, 0, 1, 0};
    int result = jumpingOnClouds(c);
    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
