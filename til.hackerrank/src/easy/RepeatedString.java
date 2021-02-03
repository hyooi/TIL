package easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {
    int sLen = s.length();
    int aCntInStr = getACnt(s);
    int remainCnt = getACnt(s.substring(0, (int) (n % sLen)));

    return (n / sLen * aCntInStr) + remainCnt;
  }

  private static int getACnt(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if ("a".equals(String.valueOf(s.charAt(i)))) {
        cnt++;
      }
    }

    return cnt;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();
    long n = scanner.nextLong();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long result = repeatedString(s, n);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();
    scanner.close();
  }
}
