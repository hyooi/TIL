package easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwoString {

  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    String result = "NO";

    char[] ch1 = s1.toCharArray();
    char[] ch2 = s2.toCharArray();
    Arrays.sort(ch1);
    Arrays.sort(ch2);

    int i = 0;
    int j = 0;
    while (true) {
      if (ch1.length == i || ch2.length == j) {
        break;
      }

      if (ch1[i] == ch2[j]) {
        result = "YES";
        break;
      }

      if (ch1[i] > ch2[j]) {
        j++;
        continue;
      }

      if (ch1[i] < ch2[j]) {
        i++;
        continue;
      }
    }

    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String result = twoStrings(s1, s2);
      System.out.println(result);
      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
