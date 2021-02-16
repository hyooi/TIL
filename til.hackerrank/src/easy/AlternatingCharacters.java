package easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s) {
    int deleteCnt = 0;
    char before = 0;

    for (int i = 0; i < s.length(); i++) {
      char now = s.charAt(i);
      if (before == now) {
        deleteCnt++;
      }
      before = now;
    }

    return deleteCnt;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = alternatingCharacters(s);
      System.out.println(result);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

//    bufferedWriter.close();

    scanner.close();
  }
}
