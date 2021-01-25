package easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesByMatch {

  static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> sockMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int cntByColor = sockMap.getOrDefault(ar[i], 0);
      sockMap.put(ar[i], cntByColor + 1);
    }

    int numberOfPairs = 0;
    for (Integer color : sockMap.keySet()) {
      numberOfPairs += sockMap.get(color) / 2;
    }

    return numberOfPairs;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);
    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
