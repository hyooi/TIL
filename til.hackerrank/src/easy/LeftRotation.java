package easy;

import java.io.IOException;
import java.util.Arrays;

public class LeftRotation {

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int[] resultArr = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      int num = i + d;
      num = (num >= a.length) ? num - a.length : num;
      resultArr[num] = a[i];
    }

    return resultArr;
  }

//  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//    String[] nd = scanner.nextLine().split(" ");

    int n = 20;//Integer.parseInt(nd[0]);

    int d = 10;//Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = "41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51"
        .split(" ");//scanner.nextLine().split(" ");
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] result = rotLeft(a, d);
    System.out.println(Arrays.toString(result));
//    for (int i = 0; i < result.length; i++) {
//      bufferedWriter.write(String.valueOf(result[i]));
//
//      if (i != result.length - 1) {
//        bufferedWriter.write(" ");
//      }
//    }

//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//
//    scanner.close();
  }
}
