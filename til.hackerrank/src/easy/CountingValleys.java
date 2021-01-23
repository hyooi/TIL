package easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingValleys {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int steps = Integer.parseInt(bufferedReader.readLine().trim());

    String path = bufferedReader.readLine();

    int result = Result.countingValleys(steps, path);
    System.out.println(result);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}

class Result {

  /*
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER steps
   *  2. STRING path
   */

  public static int countingValleys(int steps, String path) {
    int now = 0;
    int vallysCounting = 0;
    boolean isVally = false;

    for (int i = 0; i < steps; i++) {
      String step = path.substring(i, i + 1);
      switch (step) {
        case "U":
          now += 1;
          break;
        case "D":
          now -= 1;
          break;
        default:
          break;
      }

      if (now < 0) {
        isVally = true;
      }

      if (isVally && now == 0) {
        vallysCounting++;
        isVally = false;
      }
    }

    return vallysCounting;
  }

}