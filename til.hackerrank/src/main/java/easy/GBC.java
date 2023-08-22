package easy;

import java.util.Scanner;

public class GBC {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String[] nm = scan.nextLine().split(" ");
    int n = Integer.parseInt(nm[0]); //각 구간의 길이 및 제한속도
    int m = Integer.parseInt(nm[1]); // 실제 테스트할 구간의 길이 및 실제속도

    int[] building = new int[100];

    String[] input = scan.nextLine().split(" ");
    int length = Integer.parseInt(input[0]);
    int speed = Integer.parseInt(input[1]);
    for (int i=1; i<100; i++) {
      building[i] = speed;

      if (i >= length) {
        input = scan.nextLine().split(" ");
        length += Integer.parseInt(input[0]);
        speed = Integer.parseInt(input[1]);
      }
    }

    // System.out.println(Arrays.toString(building));

    input = scan.nextLine().split(" ");
    int curLength = Integer.parseInt(input[0]);
    int curSpeed = Integer.parseInt(input[1]);
    int maxSpeed = 0; //가장 크게 제한속도를 넘어간 구간
    for (int i=1; i<100; i++) {
      // System.out.println("curSpeed :" + curSpeed + "i : " +i + "maxSpeed :" + maxSpeed);
      if(maxSpeed < curSpeed - building[i]) {
        maxSpeed = curSpeed - building[i];
      }

      if (i >= curLength) {
        input = scan.nextLine().split(" ");
        curLength += Integer.parseInt(input[0]);
        curSpeed = Integer.parseInt(input[1]);
      }
    }

    // 제한속도를 가장 크게 벗어난 값을 출력
    System.out.println(maxSpeed);
    scan.close();
  }
}
