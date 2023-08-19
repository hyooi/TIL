package easy;

import java.util.Scanner;

public class WorkingHours {
  public static void main(String args[])
  {
    // 출퇴근시간 줌. 5일간 몇분 근무했는지 프로그램 구하기
    // 월 -> 월 퇴근
    Scanner scan = new Scanner(System.in);
    int total = 0;
    for (int i=0; i<5; i++) {
      String time = scan.nextLine();
      total += circulateTime(time.split(" "));
    }

    System.out.println(total);
    scan.close();
  }

  private static int circulateTime(String[] times) {
    String[] startTime = times[0].split(":");
    String[] endTime = times[1].split(":");

    int calculatedStartTime = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
    int calculatedEndTime = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

    return calculatedEndTime - calculatedStartTime;
  }
}
