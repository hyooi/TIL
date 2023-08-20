package easy;

import java.util.Scanner;

public class MapBuilding {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    // 0-> 2*2; + 2의 0승
    // 1-> 3*3 + 2의 1승
    // 2-> 5*5 + 2의 2승
    // 3-> 9*9
    // 2의 배수만큼 변의 갯수가 커짐
    int result = 2;
    for (int i=0; i<n; i++) {
      int temp = 1;
      for (int j=0; j<i; j++) {
        temp *= 2;
      }

      result += temp;
    }

    System.out.println(result * result);
  }
}
