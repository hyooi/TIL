package easy;

public class TimeConversion {
  public static String timeConversion(String s) {
    String[] splitTime = s.split(":");
    int hh = Integer.parseInt(splitTime[0]);
    String mm = splitTime[1];
    String ss = splitTime[2].substring(0,2);
    boolean isAm = "AM".equals(splitTime[2].substring(2));

    if (isAm && hh >= 12) {
      hh -= 12;
    } else if (!isAm && hh < 12) {
      hh += 12;
    }

    return String.format("%02d:%s:%s", hh, mm, ss);
  }

  //pm일땐 12보다 작으면 +12, am일땐 12보다 같거나 크면 -12
  public static void main(String[] args) {
    System.out.println(timeConversion("07:05:45PM")); //19:05:45
    System.out.println(timeConversion("12:01:00PM")); //12:01:00
    System.out.println(timeConversion("12:01:00AM")); //00:01:00
    System.out.println(timeConversion("12:00:00AM")); //00:00:00
    System.out.println(timeConversion("07:00:00AM")); //07:00:00
  }
}
