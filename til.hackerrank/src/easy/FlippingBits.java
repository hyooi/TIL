package easy;

import java.io.IOException;
import java.util.Scanner;

public class FlippingBits {

  static long flippingBits(long n) {
    char[] arr = Long.toBinaryString(n).toCharArray();
    char[] flippedArr = new char[32];

    for (int i = 0; i < arr.length; i++) {
      flippedArr[flippedArr.length - arr.length + i] = arr[i];
    }

    for (int i = 0; i < flippedArr.length; i++) {
      char val = flippedArr[i] == '1' ? '0' : '1';
      flippedArr[i] = val;
    }

    long result = 0;
    String binary = new String(flippedArr);
    for (int pow = (binary.length() - 1); pow > -1; pow--) {
      if (binary.charAt(pow) == '1') {
        result += (Math.pow(2, (binary.length() - pow - 1)));
      }
    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      long n = scanner.nextLong();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      long result = flippingBits(n);
      System.out.println(result);
//      bufferedWriter.write(String.valueOf(result));
//      bufferedWriter.newLine();
    }

//    bufferedWriter.close();

    scanner.close();
  }
}
