package medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagrams {

  static int sherlockAndAnagrams(String s) {
    int cnt = 0;

    for (int i = 1; i <= s.length() - 1; i++) {
      for (int j = 0; i + j <= s.length(); j++) {
        char[] temp1 = s.substring(j, j + i).toCharArray();
        Arrays.sort(temp1);
        for (int k = j + 1; i + k <= s.length(); k++) {
          char[] temp2 = s.substring(k, k + i).toCharArray();
          Arrays.sort(temp2);
          if ((new String(temp1)).equals(new String(temp2))) {
            cnt++;
          }
        }
      }
    }

    return cnt;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = sherlockAndAnagrams(s);
      System.out.println(result);

//      bufferedWriter.write(String.valueOf(result));
//      bufferedWriter.newLine();
    }

//    bufferedWriter.close();

    scanner.close();
  }
}
