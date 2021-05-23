package easy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagram {

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    Map<Character, Integer> map = new HashMap<>();
    for (char temp : a.toCharArray()) {
      int i = map.getOrDefault(temp, 0);
      map.put(temp, i + 1);
    }

    for (char temp : b.toCharArray()) {
      int i = map.getOrDefault(temp, 0);
      map.put(temp, i - 1);
    }

    return map.values()
        .stream()
        .reduce(0, (i1, i2) -> i1 + Math.abs(i2));
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String a = scanner.nextLine();
    String b = scanner.nextLine();

    int res = makeAnagram(a, b);
    System.out.println(res);

//    bufferedWriter.write(String.valueOf(res));
//    bufferedWriter.newLine();

//    bufferedWriter.close();

    scanner.close();
  }
}
